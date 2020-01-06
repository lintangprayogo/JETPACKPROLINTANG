package com.lintang.jetpackprolintang.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.lintang.jetpackprolintang.base.data.source.Repository
import com.lintang.jetpackprolintang.base.utils.Injection
import com.lintang.jetpackprolintang.content.ui.movie.MovieViewModel
import com.lintang.jetpackprolintang.content.ui.series.SeriesViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(val repository: Repository) : NewInstanceFactory() {
    companion object {
        @Volatile
        @JvmStatic
        private var INSTANCE: ViewModelFactory? = null

        @JvmStatic
        fun getInstance(): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE =
                        ViewModelFactory(Injection.provideRepo())

                }
            }
            return INSTANCE!!
        }

    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            return MovieViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(SeriesViewModel::class.java)) {
            return SeriesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}