package com.lintang.jetpackprolintang.base.data.source.local.room

import androidx.paging.DataSource
import androidx.room.*
import com.lintang.jetpackprolintang.base.data.source.local.entity.MovieEntity
import com.lintang.jetpackprolintang.base.data.source.local.entity.SeriesEntity

@Dao
interface MovieSeriesDao {
    //Movie Database
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovies(movieEntitys: List<MovieEntity>)

    @Query("SELECT * FROM  movie_table order by id asc")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM  movie_table where favorite=1")
    fun getMoviesFavorit(): DataSource.Factory<Int, MovieEntity>

    @Update
    fun updateMovie(movie: MovieEntity)


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertSerieses(series: List<SeriesEntity>)

    @Query("SELECT * FROM  series_table order by id asc")
    fun getSeries(): DataSource.Factory<Int, SeriesEntity>

    @Query("SELECT * FROM series_table where favorite=1")
    fun getSeriesesFavorite(): DataSource.Factory<Int, SeriesEntity>

    @Update
    fun updateSeries(series: SeriesEntity)


}