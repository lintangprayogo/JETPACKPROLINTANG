package com.lintang.jetpackprolintang.base.data.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lintang.jetpackprolintang.base.data.model.MovieModel
import com.lintang.jetpackprolintang.base.data.model.SeriesModel
import com.lintang.jetpackprolintang.base.data.source.remote.RemoteRepository

class Repository(val remoteRepository: RemoteRepository) : DataSource {
    companion object {
        @JvmStatic
        @Volatile
        private var INSTANCE: Repository? = null
        private var TAG = "Repository"

        @JvmStatic
        fun getInstance(remoteRepository: RemoteRepository): Repository {
            return INSTANCE ?: Repository(remoteRepository).also {
                INSTANCE = Repository(remoteRepository)
            }

        }


    }

    override fun getMovies(): LiveData<List<MovieModel>> {
        val result: MutableLiveData<List<MovieModel>> = MutableLiveData()
        remoteRepository.getMovies(object : LoadCallback<List<MovieModel>> {
            override fun onDataReceived(data: List<MovieModel>) {
                result.postValue(data)
            }

            override fun onDataNotAvailble(msg: String) {
                result.postValue(null)
                Log.d(TAG, msg)
            }

        })

        return result
    }

    override fun getSerieses(): LiveData<List<SeriesModel>> {
        val result: MutableLiveData<List<SeriesModel>> = MutableLiveData()

        remoteRepository.getSerieses(object : LoadCallback<List<SeriesModel>> {
            override fun onDataReceived(data: List<SeriesModel>) {
                result.postValue(data)
            }

            override fun onDataNotAvailble(msg: String) {
                result.postValue(null)
                Log.d(TAG, msg)
            }

        })


        return result
    }

}