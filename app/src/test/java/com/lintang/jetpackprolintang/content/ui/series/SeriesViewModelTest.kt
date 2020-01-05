package com.lintang.jetpackprolintang.content.ui.series

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.lintang.jetpackprolintang.base.data.model.SeriesModel
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
    fun getSerieses(){
        val dummy: List<SeriesModel> = DataDummy.generateSeries()
        val result: MutableLiveData<List<SeriesModel>> = MutableLiveData()
        result.value = dummy
        Mockito.`when`(repository.getSerieses()).thenReturn(result)
        val observer = mock(Observer::class.java) as Observer<List<SeriesModel>>
        mViewModel.getSerieses().observeForever(observer)
        verify(observer).onChanged(dummy)
    }

}