package com.lintang.jetpackprolintang.base.data.source.local

import androidx.paging.DataSource
import com.lintang.jetpackprolintang.base.data.source.local.entity.MovieEntity
import com.lintang.jetpackprolintang.base.data.source.local.entity.SeriesEntity
import com.lintang.jetpackprolintang.base.data.source.local.room.MovieSeriesDao

class LocalRepository(private val mMovieSeriesDao: MovieSeriesDao) {

    companion object {
        @JvmStatic
        private var INSTANCE: LocalRepository? = null

        @JvmStatic
        fun getInstance(mSeriesDao: MovieSeriesDao): LocalRepository {
            return INSTANCE ?: LocalRepository(mSeriesDao).also { INSTANCE = it }
        }
    }


    fun getMovies(): DataSource.Factory<Int, MovieEntity> {
        return mMovieSeriesDao.getMovies()
    }

    fun getMoviesFavorite(): DataSource.Factory<Int, MovieEntity> {
        return mMovieSeriesDao.getMoviesFavorit()
    }

    fun insertMovies(list: List<MovieEntity>) {
        mMovieSeriesDao.insertMovies(list)
    }

    fun updateMovie(movie: MovieEntity) {
        mMovieSeriesDao.updateMovie(movie)
    }


    fun getSerieses(): DataSource.Factory<Int, SeriesEntity> {
        return mMovieSeriesDao.getSeries()
    }


    fun insertSerieses(list: List<SeriesEntity>) {
        mMovieSeriesDao.insertSerieses(list)
    }

    fun getSeriesesFavorite(): DataSource.Factory<Int, SeriesEntity> {
        return mMovieSeriesDao.getSeriesesFavorite()
    }

    fun updateSeries(series: SeriesEntity) {
        mMovieSeriesDao.updateSeries(series)
    }


}