package com.lintang.jetpackprolintang.content.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.lintang.jetpackprolintang.base.data.source.Repository
import com.lintang.jetpackprolintang.base.data.source.local.entity.MovieEntity
import com.lintang.jetpackprolintang.base.vo.Resource

class MovieViewModel(val repository: Repository) : ViewModel() {


    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = repository.getMovies()

    fun setMovieFavorite(movieEntity: MovieEntity) {
        repository.setMovieFavorite(movieEntity)
    }

    fun getMoviesFavorite(): LiveData<Resource<PagedList<MovieEntity>>> =
        repository.getMoviesFavorite()


}