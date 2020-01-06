package com.lintang.jetpackprolintang.base.utils

import com.lintang.jetpackprolintang.base.data.source.Repository
import com.lintang.jetpackprolintang.base.data.source.remote.RemoteRepository

class Injection {
    companion object {
        @JvmStatic
        fun provideRepo(): Repository {
            val remoteRepository: RemoteRepository = RemoteRepository.getInstance()
            return Repository.getInstance(remoteRepository)
        }
    }

}