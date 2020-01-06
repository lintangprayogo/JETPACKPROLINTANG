package com.lintang.jetpackprolintang.base.data.source.remote

import android.annotation.SuppressLint
import com.lintang.jetpackprolintang.base.data.model.MovieModel
import com.lintang.jetpackprolintang.base.data.model.SeriesModel
import com.lintang.jetpackprolintang.base.data.source.LoadCallback
import com.lintang.jetpackprolintang.base.utils.EspressoIdlingResource
import io.reactivex.schedulers.Schedulers

class RemoteRepository() {
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
    fun getMovies(callback: LoadCallback<List<MovieModel>>) {
        EspressoIdlingResource.increment()
        ApiService.getApiService.getMovies().subscribeOn(Schedulers.io())
            .doOnError { callback.onDataNotAvailble(it.localizedMessage ?: "Unknown") }
            .doOnTerminate { EspressoIdlingResource.decrement() }
            .subscribe { callback.onDataReceived(it.results ?: listOf()) }
    }

    @SuppressLint("CheckResult")
    fun getSerieses(callback: LoadCallback<List<SeriesModel>>) {
        EspressoIdlingResource.increment()
        ApiService.getApiService.getTvShow().subscribeOn(Schedulers.io())
            .doOnError { callback.onDataNotAvailble(it.localizedMessage ?: "Unknown") }
            .doOnTerminate { EspressoIdlingResource.decrement() }.subscribe {
                callback.onDataReceived(it.results ?: listOf())
            }
    }
}