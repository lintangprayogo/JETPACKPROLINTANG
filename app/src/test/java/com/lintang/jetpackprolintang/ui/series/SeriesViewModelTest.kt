package com.lintang.jetpackprolintang.ui.series

import com.lintang.jetpackprolintang.data.Series
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class SeriesViewModelTest {

    lateinit var seriesViewModel: SeriesViewModel
    lateinit var dummy: Series

    @Before
    fun setUp() {
        seriesViewModel = SeriesViewModel()
        dummy = Series(
            "82856", "The Mandalorian", 7.9, "2019-11-12",
            "/BbNvKCuEF4SRzFXR16aK6ISFtR.jpg", "/o7qi2v4uWQ8bZ1tW3KI0Ztn2epk.jpg",
            "any perils to uncover the truth about a lost expedition that decades before boldly faced emptiness and silence in search of the unknown."
        )
    }

    @Test
    fun getSerieses() {
        val serieses = seriesViewModel.getSerieses()
        assertNotNull(serieses)
        assertEquals(10, serieses.size)
    }

    @Test
    fun findSeries() {
        val series = seriesViewModel.findSeries(dummy.id ?: "0")
        assertNotNull(series)
        assertEquals(dummy.id, series?.id)
        assertEquals(dummy.overview, series?.overview)
        assertEquals(dummy.title, series?.title)
        assertEquals(dummy.backgroundPath, series?.backgroundPath)
        assertEquals(dummy.posterPath, series?.posterPath)
        assertEquals(dummy.voteAverage,series?.voteAverage)
    }
}