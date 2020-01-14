@file:Suppress("DEPRECATION")

package com.lintang.jetpackprolintang.content.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.lintang.jetpackprolintang.base.data.source.Repository
import com.lintang.jetpackprolintang.base.data.source.local.entity.MovieEntity
import com.lintang.jetpackprolintang.base.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


@Suppress("UNCHECKED_CAST")
class MovieViewModelTest {

    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var mViewModel: MovieViewModel
    @Mock
    private lateinit var repository: Repository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mViewModel = MovieViewModel(repository)
    }


    @Test
    fun getMovies() {
        val dummyMovies: MutableLiveData<Resource<PagedList<MovieEntity>>> = MutableLiveData()
        val pagedList: PagedList<MovieEntity> =
            mock(PagedList::class.java) as PagedList<MovieEntity>
        dummyMovies.value = Resource.success(pagedList)
        `when`(repository.getMovies()).thenReturn(dummyMovies)
        val observer: Observer<Resource<PagedList<MovieEntity>>> =
            mock(Observer::class.java) as Observer<Resource<PagedList<MovieEntity>>>
        mViewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(Resource.success(pagedList))

    }

    @Test
    fun getMovieFavorite() {
        val dummyMovies: MutableLiveData<Resource<PagedList<MovieEntity>>> = MutableLiveData()
        val pagedList: PagedList<MovieEntity> =
            mock(PagedList::class.java) as PagedList<MovieEntity>
        dummyMovies.value = Resource.success(pagedList)
        `when`(repository.getMoviesFavorite()).thenReturn(dummyMovies)
        val observer: Observer<Resource<PagedList<MovieEntity>>> =
            mock(Observer::class.java) as Observer<Resource<PagedList<MovieEntity>>>
        mViewModel.getMoviesFavorite().observeForever(observer)
        verify(observer).onChanged(Resource.success(pagedList))
    }


}