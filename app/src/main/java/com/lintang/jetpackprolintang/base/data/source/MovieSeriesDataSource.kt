package com.lintang.jetpackprolintang.base.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.lintang.jetpackprolintang.base.data.source.local.entity.MovieEntity
import com.lintang.jetpackprolintang.base.data.source.local.entity.SeriesEntity
import com.lintang.jetpackprolintang.base.vo.Resource

interface MovieSeriesDataSource {
    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>>
    fun getMoviesFavorite(): LiveData<Resource<PagedList<MovieEntity>>>
    fun setMovieFavorite(movie: MovieEntity)

    fun getSerieses(): LiveData<Resource<PagedList<SeriesEntity>>>
    fun getSeriesesFavorite(): LiveData<Resource<PagedList<SeriesEntity>>>
    fun setSeriesFavorite(series: SeriesEntity)

}