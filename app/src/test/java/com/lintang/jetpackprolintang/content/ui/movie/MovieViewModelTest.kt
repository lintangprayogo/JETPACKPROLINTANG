@file:Suppress("DEPRECATION")

package com.lintang.jetpackprolintang.content.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.lintang.jetpackprolintang.base.data.model.MovieModel
import com.lintang.jetpackprolintang.base.data.source.Repository
import com.lintang.jetpackprolintang.base.utils.DataDummy
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
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
        val dummy: List<MovieModel> = DataDummy.generateMovie()
        val result: MutableLiveData<List<MovieModel>> = MutableLiveData()
        result.value = dummy
        Mockito.`when`(repository.getMovies()).thenReturn(result)
        val observer = mock(Observer::class.java) as Observer<List<MovieModel>>
        mViewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummy)
    }


}