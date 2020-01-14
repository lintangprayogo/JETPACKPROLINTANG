package com.lintang.jetpackprolintang.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.lintang.jetpackprolintang.base.data.source.MovieSeriesDataSource
import com.lintang.jetpackprolintang.base.data.source.NetworkBoundResource
import com.lintang.jetpackprolintang.base.data.source.Repository
import com.lintang.jetpackprolintang.base.data.source.local.LocalRepository
import com.lintang.jetpackprolintang.base.data.source.local.entity.MovieEntity
import com.lintang.jetpackprolintang.base.data.source.local.entity.SeriesEntity
import com.lintang.jetpackprolintang.base.data.source.remote.ApiResponse
import com.lintang.jetpackprolintang.base.data.source.remote.RemoteRepository
import com.lintang.jetpackprolintang.base.data.source.remote.model.MovieModel
import com.lintang.jetpackprolintang.base.data.source.remote.model.SeriesModel
import com.lintang.jetpackprolintang.base.utils.AppExecutors
import com.lintang.jetpackprolintang.base.vo.Resource

class FakeRepository(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository,
    private val appExecutors: AppExecutors
) : MovieSeriesDataSource {

    companion object {
        @JvmStatic
        @Volatile
        private var INSTANCE: Repository? = null

        @JvmStatic
        fun getInstance(
            remoteRepository: RemoteRepository,
            localRepository: LocalRepository,
            appExecutors: AppExecutors
        ): Repository {
            return INSTANCE ?: Repository(remoteRepository, localRepository, appExecutors).also {
                INSTANCE = it
            }

        }


    }

    override fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MovieModel>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                return LivePagedListBuilder<Int, MovieEntity>(
                    localRepository.getMovies(),
                    20
                ).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>): Boolean {
                return data.isNullOrEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<MovieModel>>> {
                return remoteRepository.getMovies()
            }

            override fun saveCallResult(data: List<MovieModel>?) {
                val movieModels = data ?: listOf()
                val movieEntitys = mutableListOf<MovieEntity>()
                movieModels.forEach {
                    movieEntitys.add(
                        MovieEntity(
                            it.id,
                            it.title,
                            it.voteAverage,
                            it.realeseDate,
                            it.posterPath,
                            it.backgroundPath,
                            it.overview,
                            false
                        )
                    )
                }
                localRepository.insertMovies(movieEntitys)
            }


        }.asLiveData()
    }

    override fun getMoviesFavorite(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MovieModel>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                return LivePagedListBuilder<Int, MovieEntity>(
                    localRepository.getMoviesFavorite(),
                    20
                ).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>): Boolean {
                return false
            }

            override fun createCall(): LiveData<ApiResponse<List<MovieModel>>> {
                return MutableLiveData<ApiResponse<List<MovieModel>>>()
            }

            override fun saveCallResult(data: List<MovieModel>?) {}

        }.asLiveData()
    }

    override fun setMovieFavorite(movie: MovieEntity) {

        movie.favorite = !movie.favorite
        val runnable = { localRepository.updateMovie(movie) }

        appExecutors.diskIO().execute(runnable)
    }

    override fun getSerieses(): LiveData<Resource<PagedList<SeriesEntity>>> {
        return object :
            NetworkBoundResource<PagedList<SeriesEntity>, List<SeriesModel>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<SeriesEntity>> {
                return LivePagedListBuilder<Int, SeriesEntity>(
                    localRepository.getSerieses(),
                    20
                ).build()
            }

            override fun shouldFetch(data: PagedList<SeriesEntity>): Boolean {
                return data.isNullOrEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<SeriesModel>>> {
                return remoteRepository.getSerieses()
            }

            override fun saveCallResult(data: List<SeriesModel>?) {
                val seriesModels = data ?: listOf()
                val seriesEntitys = mutableListOf<SeriesEntity>()
                seriesModels.forEach {
                    seriesEntitys.add(
                        SeriesEntity(
                            it.id,
                            it.title,
                            it.voteAverage,
                            it.realeseDate,
                            it.posterPath,
                            it.backgroundPath,
                            it.overview
                            , false
                        )
                    )
                }
                localRepository.insertSerieses(seriesEntitys)
            }


        }.asLiveData()
    }

    override fun getSeriesesFavorite(): LiveData<Resource<PagedList<SeriesEntity>>> {
        return object :
            NetworkBoundResource<PagedList<SeriesEntity>, List<SeriesModel>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<SeriesEntity>> {
                return LivePagedListBuilder<Int, SeriesEntity>(
                    localRepository.getSeriesesFavorite(),
                    20
                ).build()
            }

            override fun shouldFetch(data: PagedList<SeriesEntity>): Boolean {
                return false
            }

            override fun createCall(): LiveData<ApiResponse<List<SeriesModel>>> {
                return MutableLiveData<ApiResponse<List<SeriesModel>>>()
            }

            override fun saveCallResult(data: List<SeriesModel>?) {}

        }.asLiveData()
    }

    override fun setSeriesFavorite(series: SeriesEntity) {
        series.favorite = !series.favorite
        val runable = { localRepository.updateSeries(series) }
        appExecutors.diskIO().execute(runable)
    }
}