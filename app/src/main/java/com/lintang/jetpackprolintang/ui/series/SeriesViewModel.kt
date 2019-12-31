package com.lintang.jetpackprolintang.ui.series

import androidx.lifecycle.ViewModel
import com.lintang.jetpackprolintang.base.utils.DataDummy
import com.lintang.jetpackprolintang.data.Series

class SeriesViewModel : ViewModel() {
    fun getSerieses(): List<Series> {
        return DataDummy.generateSeries()
    }

    fun findSeries(id: String): Series? {
        return DataDummy.findSeries(id)
    }
}