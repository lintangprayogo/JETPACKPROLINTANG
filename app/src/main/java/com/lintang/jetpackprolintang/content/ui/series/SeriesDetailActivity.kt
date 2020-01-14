package com.lintang.jetpackprolintang.content.ui.series

import android.os.Bundle
import com.bumptech.glide.Glide
import com.lintang.jetpackprolintang.BuildConfig
import com.lintang.jetpackprolintang.R
import com.lintang.jetpackprolintang.base.data.source.local.entity.SeriesEntity
import com.lintang.jetpackprolintang.base.ui.BaseActivity
import com.lintang.jetpackprolintang.base.utils.Helper.Func.toDatetoString
import kotlinx.android.synthetic.main.activity_series_detail.*


class SeriesDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_series_detail)
        supportActionBar?.hide()
        val mVieModel = obtainViewModel<SeriesViewModel>()
        if (checkExtra(SeriesFragment.TAG)) {
            val series = baseGetExtraData<SeriesEntity>(SeriesFragment.TAG)
            setUpData(series)
            favorite_toggle.setOnClickListener {
                setUpToggle(!series.favorite)
                mVieModel.setSeriesFavorite(series)
            }
        }
    }

    private fun setUpData(data: SeriesEntity?) {
        title_series.text = data?.title
        overview.text = data?.overview
        rate_series.text = data?.voteAverage.toString()
        date.text = toDatetoString(data?.firstAirDate ?: "", "EEE, dd MMM yyyy")
        Glide.with(this).load("${BuildConfig.SMALL_PATH}${data?.posterPath}").into(photo)
        Glide.with(this).load("${BuildConfig.HIGH_PATH}${data?.backgroundPath}")
            .into(background_series)
        data?.favorite.let { setUpToggle(it ?: false) }

    }

    private fun setUpToggle(state: Boolean) {
        if (state) {
            icon.setImageResource(R.drawable.ic_heart_fill)
        } else {
            icon.setImageResource(R.drawable.ic_heart)
        }
    }

}
