package com.lintang.jetpackprolintang.ui.movie

import androidx.lifecycle.ViewModel
import com.lintang.jetpackprolintang.base.utils.DataDummy
import com.lintang.jetpackprolintang.data.Movie

class MovieViewModel : ViewModel() {

    fun getMovies(): List<Movie> {
        return DataDummy.generateMovie()
    }

    fun findMovie(id: String?): Movie? {
        return DataDummy.findMovie(id ?: "0")

    }

}