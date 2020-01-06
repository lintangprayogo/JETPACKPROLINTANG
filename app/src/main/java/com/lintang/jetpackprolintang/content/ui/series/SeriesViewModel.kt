package com.lintang.jetpackprolintang.content.ui.series

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lintang.jetpackprolintang.base.data.model.SeriesModel
import com.lintang.jetpackprolintang.base.data.source.Repository

class SeriesViewModel(val repository: Repository) : ViewModel() {
    fun getSerieses(): LiveData<List<SeriesModel>> {
        return repository.getSerieses()
    }


}