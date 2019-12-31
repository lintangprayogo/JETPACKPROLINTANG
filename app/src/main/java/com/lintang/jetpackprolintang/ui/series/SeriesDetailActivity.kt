package com.lintang.jetpackprolintang.ui.series

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.fero.base.view.ui.BaseActivity
import com.lintang.jetpackprolintang.BuildConfig
import com.lintang.jetpackprolintang.R
import com.lintang.jetpackprolintang.data.Series
import kotlinx.android.synthetic.main.activity_series_detail.*

class SeriesDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_series_detail)
        supportActionBar?.hide()
        if (checkExtra(SeriesFragment.TAG)) {
            val id = baseGetExtraData<String>(SeriesFragment.TAG)
            val mViewModel = ViewModelProviders.of(this).get(SeriesViewModel::class.java)
            setUpData(mViewModel.findSeries(id))

        }
    }

    private fun setUpData(data: Series?) {
        title_series.text = data?.title
        overview.text = data?.overview
        rate_series.text = data?.voteAverage.toString()
        date.text = data?.realeseDate
        Glide.with(this).load("${BuildConfig.SMALL_PATH}${data?.posterPath}").into(photo)
        Glide.with(this).load("${BuildConfig.HIGH_PATH}${data?.backgroundPath}")
            .into(background_series)

    }
}
