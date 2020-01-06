package com.lintang.jetpackprolintang.content.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lintang.jetpackprolintang.base.data.model.MovieModel
import com.lintang.jetpackprolintang.base.data.source.Repository

class MovieViewModel(val repository: Repository) : ViewModel() {


    fun getMovies(): LiveData<List<MovieModel>> {
        return repository.getMovies()
    }


}