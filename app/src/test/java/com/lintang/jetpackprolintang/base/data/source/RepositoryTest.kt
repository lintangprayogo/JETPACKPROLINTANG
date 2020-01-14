package com.lintang.jetpackprolintang.base.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import androidx.paging.PagedList
import com.lintang.jetpackprolintang.base.data.source.local.LocalRepository
import com.lintang.jetpackprolintang.base.data.source.local.entity.MovieEntity
import com.lintang.jetpackprolintang.base.data.source.local.entity.SeriesEntity
import com.lintang.jetpackprolintang.base.data.source.remote.RemoteRepository
import com.lintang.jetpackprolintang.base.utils.DataDummy
import com.lintang.jetpackprolintang.base.vo.Resource
import com.lintang.jetpackprolintang.data.FakeRepository
import com.lintang.jetpackprolintang.utils.InstantAppExecutors
import com.lintang.jetpackprolintang.utils.PagedListUtil
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

@Suppress("UNCHECKED_CAST")
class RepositoryTest {
    @get:Rule
    var instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    private lateinit var remote: RemoteRepository
    @Mock
    private lateinit var local: LocalRepository
    @Mock
    private lateinit var instantAppExecutors: InstantAppExecutors
    private lateinit var fakeRepository: FakeRepository
    private val movieEntitys = DataDummy.generateMovieEntity()
    private val seriesEntitys = DataDummy.generateSeriesEntity()


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        fakeRepository = FakeRepository(remote, local, instantAppExecutors)
    }

    @Test
    fun getMovies() {
        val dataSourceFactory: DataSource.Factory<Int, MovieEntity> =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMovies()).thenReturn(dataSourceFactory)
        fakeRepository.getMovies()
        val result: Resource<PagedList<MovieEntity>> =
            Resource.success(PagedListUtil.mockPagedList(movieEntitys))
        verify(local).getMovies()
        assertNotNull(result.data)
        assertEquals(movieEntitys.size, result.data?.size)


    }

    @Test
    fun getMoviesFavorite() {
        val dataSourceFactory: DataSource.Factory<Int, MovieEntity> =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMoviesFavorite()).thenReturn(dataSourceFactory)
        fakeRepository.getMoviesFavorite()
        val result: Resource<PagedList<MovieEntity>> =
            Resource.success(PagedListUtil.mockPagedList(movieEntitys))
        verify(local).getMoviesFavorite()
        assertNotNull(result.data)
        assertEquals(movieEntitys.size, result.data?.size)

    }

    @Test
    fun getSerieses() {
        val dataSourceFactory: DataSource.Factory<Int, SeriesEntity> =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, SeriesEntity>
        `when`(local.getSerieses()).thenReturn(dataSourceFactory)
        fakeRepository.getSerieses()
        val result: Resource<PagedList<SeriesEntity>> =
            Resource.success(PagedListUtil.mockPagedList(seriesEntitys))
        verify(local).getSerieses()
        assertNotNull(result.data)
        assertEquals(seriesEntitys.size, result.data?.size)
    }

    @Test
    fun getSeriesesFavorite() {
        val dataSourceFactory: DataSource.Factory<Int, SeriesEntity> =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, SeriesEntity>
        `when`(local.getSeriesesFavorite()).thenReturn(dataSourceFactory)
        fakeRepository.getSeriesesFavorite()
        val result: Resource<PagedList<SeriesEntity>> =
            Resource.success(PagedListUtil.mockPagedList(seriesEntitys))
        verify(local).getSeriesesFavorite()
        assertNotNull(result.data)
        assertEquals(seriesEntitys.size, result.data?.size)
    }
}