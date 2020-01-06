package com.lintang.jetpackprolintang.content.ui.movie

import android.os.Bundle
import com.bumptech.glide.Glide
import com.lintang.jetpackprolintang.BuildConfig
import com.lintang.jetpackprolintang.R
import com.lintang.jetpackprolintang.base.data.model.MovieModel
import com.lintang.jetpackprolintang.base.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        supportActionBar?.hide()
        if (checkExtra(MovieFragment.TAG)) {
            val movie = baseGetExtraData<MovieModel>(MovieFragment.TAG)
            setUpData(movie)
        }
    }


    fun setUpData(data: MovieModel?) {
        title_movie.text = data?.title
        overview.text = data?.overview
        rate_movie.text = data?.voteAverage.toString()
        date.text = data?.realeseDate
        Glide.with(this).load("${BuildConfig.SMALL_PATH}${data?.posterPath}").into(photo)
        Glide.with(this).load("${BuildConfig.HIGH_PATH}${data?.backgroundPath}")
            .into(background_movie)


    }


}
