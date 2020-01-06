package com.lintang.jetpackprolintang.base.data.source

import androidx.lifecycle.LiveData
import com.lintang.jetpackprolintang.base.data.model.MovieModel
import com.lintang.jetpackprolintang.base.data.model.SeriesModel

interface DataSource {
    fun getMovies(): LiveData<List<MovieModel>>
    fun getSerieses(): LiveData<List<SeriesModel>>
}