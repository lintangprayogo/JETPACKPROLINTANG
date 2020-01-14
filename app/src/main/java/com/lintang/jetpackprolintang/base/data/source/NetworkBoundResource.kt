package com.lintang.jetpackprolintang.base.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.lintang.jetpackprolintang.base.data.source.remote.ApiResponse
import com.lintang.jetpackprolintang.base.data.source.remote.StatusResponse.*
import com.lintang.jetpackprolintang.base.utils.AppExecutors
import com.lintang.jetpackprolintang.base.vo.Resource


abstract class NetworkBoundResource<ResultType, RequestType>(val mExecutors: AppExecutors) {
    private val result: MediatorLiveData<Resource<ResultType>> = MediatorLiveData()


    protected abstract fun loadFromDB(): LiveData<ResultType>
    protected abstract fun shouldFetch(data: ResultType): Boolean
    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>
    protected abstract fun saveCallResult(data: RequestType?)

    init {
        result.postValue(Resource.loading(null))
        val dbSource: LiveData<ResultType> = loadFromDB()
        result.addSource(dbSource) {
            result.removeSource(dbSource)
            if (shouldFetch(it)) {
                fetchFromNetwork(dbSource)
            } else {
                result.addSource(dbSource) {
                    result.postValue(Resource.success(it))
                }
            }
        }
    }

    protected fun onFetchFailed() {

    }

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
        val apiResponse: LiveData<ApiResponse<RequestType>> = createCall()
        result.addSource(dbSource) { result.value = Resource.loading(it) }
        result.addSource(apiResponse) { response ->
            result.removeSource(dbSource)
            result.removeSource(apiResponse)
            when (response.status) {
                SUCCESS -> {
                    mExecutors.diskIO().execute {
                        saveCallResult(response.body)
                        mExecutors.mainThread().execute {
                            result.addSource(loadFromDB()) {
                                result.postValue(Resource.success(it))
                            }
                        }
                    }
                }
                EMPTY -> {

                    mExecutors.diskIO().execute {
                        result.addSource(loadFromDB()) {
                            result.value = Resource.success(it)
                        }
                    }
                }
                ERROR -> {
                    onFetchFailed()
                    result.addSource(dbSource) {
                        result.value = Resource.error(response.msg, it)
                    }
                }


            }
        }
    }

    fun asLiveData(): LiveData<Resource<ResultType>> {
        return result
    }
}