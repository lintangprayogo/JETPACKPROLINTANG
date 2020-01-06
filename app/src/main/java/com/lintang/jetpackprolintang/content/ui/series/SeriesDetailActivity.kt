package com.lintang.jetpackprolintang.content.ui.series

import android.os.Bundle
import com.bumptech.glide.Glide
import com.lintang.jetpackprolintang.BuildConfig
import com.lintang.jetpackprolintang.R
import com.lintang.jetpackprolintang.base.data.model.SeriesModel
import com.lintang.jetpackprolintang.base.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_series_detail.*

class SeriesDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_series_detail)
        supportActionBar?.hide()
        if (checkExtra(SeriesFragment.TAG)) {
            val series = baseGetExtraData<SeriesModel>(SeriesFragment.TAG)
            setUpData(series)
        }
    }

    private fun setUpData(data: SeriesModel?) {
        title_series.text = data?.title
        overview.text = data?.overview
        rate_series.text = data?.voteAverage.toString()
        date.text = data?.realeseDate
        Glide.with(this).load("${BuildConfig.SMALL_PATH}${data?.posterPath}").into(photo)
        Glide.with(this).load("${BuildConfig.HIGH_PATH}${data?.backgroundPath}")
            .into(background_series)

    }
}
