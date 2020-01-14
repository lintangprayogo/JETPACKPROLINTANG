package com.lintang.jetpackprolintang.content.ui.movie

import android.os.Bundle
import com.bumptech.glide.Glide
import com.lintang.jetpackprolintang.BuildConfig
import com.lintang.jetpackprolintang.R
import com.lintang.jetpackprolintang.base.data.source.local.entity.MovieEntity
import com.lintang.jetpackprolintang.base.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        supportActionBar?.hide()

        val mVieModel = obtainViewModel<MovieViewModel>()
        if (checkExtra(MovieFragment.TAG)) {
            val movie = baseGetExtraData<MovieEntity>(MovieFragment.TAG)
            setUpData(movie)
            favorite_toggle.setOnClickListener {
                setUpToggle(!movie.favorite)
                mVieModel.setMovieFavorite(movie)
            }
        }
    }


    private fun setUpData(data: MovieEntity?) {
        title_movie.text = data?.title
        overview.text = data?.overview
        rate_movie.text = data?.voteAverage.toString()
        date.text = data?.realeseDate
        Glide.with(this).load("${BuildConfig.SMALL_PATH}${data?.posterPath}").into(photo)
        Glide.with(this).load("${BuildConfig.HIGH_PATH}${data?.backgroundPath}")
            .into(background_movie)

        data?.favorite?.let { setUpToggle(it) }
    }

    private fun setUpToggle(state: Boolean) {
        if (state) {
            icon.setImageResource(R.drawable.ic_heart_fill)
        } else {
            icon.setImageResource(R.drawable.ic_heart)
        }
    }


}
