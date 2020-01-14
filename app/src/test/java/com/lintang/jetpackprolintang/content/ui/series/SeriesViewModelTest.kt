package com.lintang.jetpackprolintang.content.ui.series

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.lintang.jetpackprolintang.base.data.source.Repository
import com.lintang.jetpackprolintang.base.data.source.local.entity.SeriesEntity
import com.lintang.jetpackprolintang.base.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

@Suppress("UNCHECKED_CAST")
class SeriesViewModelTest {
    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var mViewModel: SeriesViewModel
    @Mock
    private lateinit var repository: Repository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mViewModel = SeriesViewModel(repository)
    }

    @Test
    fun getSerieses() {
        val dummySerieses: MutableLiveData<Resource<PagedList<SeriesEntity>>> = MutableLiveData()
        val pagedList: PagedList<SeriesEntity> =
            mock(PagedList::class.java) as PagedList<SeriesEntity>
        dummySerieses.value = Resource.success(pagedList)
        `when`(repository.getSerieses()).thenReturn(dummySerieses)
        val observer: Observer<Resource<PagedList<SeriesEntity>>> =
            mock(Observer::class.java) as Observer<Resource<PagedList<SeriesEntity>>>
        mViewModel.getSerieses().observeForever(observer)
        verify(observer).onChanged(Resource.success(pagedList))

    }

    @Test
    fun getSeriesesFavorite() {
        val dummySerieses: MutableLiveData<Resource<PagedList<SeriesEntity>>> = MutableLiveData()
        val pagedList: PagedList<SeriesEntity> =
            mock(PagedList::class.java) as PagedList<SeriesEntity>
        dummySerieses.value = Resource.success(pagedList)
        `when`(repository.getSeriesesFavorite()).thenReturn(dummySerieses)
        val observer: Observer<Resource<PagedList<SeriesEntity>>> =
            mock(Observer::class.java) as Observer<Resource<PagedList<SeriesEntity>>>
        mViewModel.getSeriesesFavorite().observeForever(observer)
        verify(observer).onChanged(Resource.success(pagedList))
    }

}