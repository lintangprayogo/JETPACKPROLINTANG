package com.lintang.jetpackprolintang.ui.movie

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.fero.base.view.ui.BaseActivity
import com.lintang.jetpackprolintang.BuildConfig
import com.lintang.jetpackprolintang.R
import com.lintang.jetpackprolintang.data.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        supportActionBar?.hide()
        if (checkExtra(MovieFragment.TAG)) {
            val id = baseGetExtraData<String>(MovieFragment.TAG)
            val mViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
            setUpData(mViewModel.findMovie(id))

        }
    }


    fun setUpData(data: Movie?) {
        title_movie.text = data?.title
        overview.text = data?.overview
        rate_movie.text = data?.voteAverage.toString()
        date.text = data?.realeseDate
        Glide.with(this).load("${BuildConfig.SMALL_PATH}${data?.posterPath}").into(photo)
        Glide.with(this).load("${BuildConfig.HIGH_PATH}${data?.backgroundPath}")
            .into(background_movie)


    }


}
