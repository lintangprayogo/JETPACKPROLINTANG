package com.lintang.jetpackprolintang.base.data.source.remote

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lintang.jetpackprolintang.base.data.source.remote.model.MovieModel
import com.lintang.jetpackprolintang.base.data.source.remote.model.SeriesModel
import com.lintang.jetpackprolintang.base.utils.EspressoIdlingResource
import io.reactivex.schedulers.Schedulers

class RemoteRepository {
    companion object {
        @JvmStatic
        private var INSTANCE: RemoteRepository? = null

        @JvmStatic
        fun getInstance(): RemoteRepository {
            return INSTANCE ?: RemoteRepository().also {
                INSTANCE = it
            }
        }
    }

    @SuppressLint("CheckResult")
    fun getMovies(): LiveData<ApiResponse<List<MovieModel>>> {
        val result: MutableLiveData<ApiResponse<List<MovieModel>>> = MutableLiveData()

        EspressoIdlingResource.increment()
        ApiService.getApiService.getMovies().subscribeOn(Schedulers.io())
            .doOnError { ApiResponse.error(it.localizedMessage, null) }
            .doOnTerminate { EspressoIdlingResource.decrement() }
            .subscribe {
                result.postValue(ApiResponse.success(it.results ?: listOf()))
            }

        return result
    }

    @SuppressLint("CheckResult")
    fun getSerieses(): LiveData<ApiResponse<List<SeriesModel>>> {
        val result: MutableLiveData<ApiResponse<List<SeriesModel>>> = MutableLiveData()

        EspressoIdlingResource.increment()
        ApiService.getApiService.getTvShow().subscribeOn(Schedulers.io())
            .doOnError { ApiResponse.error(it.localizedMessage, null) }
            .doOnTerminate { EspressoIdlingResource.decrement() }.subscribe {
                result.postValue(ApiResponse.success(it.results ?: listOf()))
            }
        return result
    }
}