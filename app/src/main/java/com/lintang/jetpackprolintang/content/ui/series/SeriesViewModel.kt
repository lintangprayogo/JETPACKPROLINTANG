package com.lintang.jetpackprolintang.content.ui.series

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.lintang.jetpackprolintang.base.data.source.Repository
import com.lintang.jetpackprolintang.base.data.source.local.entity.SeriesEntity
import com.lintang.jetpackprolintang.base.vo.Resource

class SeriesViewModel(val repository: Repository) : ViewModel() {
    fun getSerieses(): LiveData<Resource<PagedList<SeriesEntity>>> {
        return repository.getSerieses()
    }

    fun getSeriesesFavorite(): LiveData<Resource<PagedList<SeriesEntity>>> {
        return repository.getSeriesesFavorite()
    }

    fun setSeriesFavorite(series: SeriesEntity) {
        repository.setSeriesFavorite(series)
    }


}