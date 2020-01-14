package com.lintang.jetpackprolintang.base.utils

import android.app.Application
import com.lintang.jetpackprolintang.base.data.source.Repository
import com.lintang.jetpackprolintang.base.data.source.local.LocalRepository
import com.lintang.jetpackprolintang.base.data.source.local.room.MovieSeriesDatabase
import com.lintang.jetpackprolintang.base.data.source.remote.RemoteRepository

class Injection {
    companion object {
        @JvmStatic
        fun provideRepo(application: Application): Repository {
            val remoteRepository: RemoteRepository = RemoteRepository.getInstance()
            val database = MovieSeriesDatabase.getDatabase(application)
            val localRepository = LocalRepository.getInstance(database.movieSeriesDao())
            val appExecutors = AppExecutors()
            return Repository.getInstance(remoteRepository, localRepository, appExecutors)
        }
    }

}