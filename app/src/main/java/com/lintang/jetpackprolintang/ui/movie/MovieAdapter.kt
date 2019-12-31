package com.lintang.jetpackprolintang.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.lintang.jetpackprolintang.BuildConfig
import com.lintang.jetpackprolintang.R

import com.lintang.jetpackprolintang.base.ui.BaseAdapter
import com.lintang.jetpackprolintang.base.ui.BaseHolder
import com.lintang.jetpackprolintang.data.Movie
import kotlinx.android.synthetic.main.items_movie.view.*

class MovieAdapter : BaseAdapter<Movie, MovieAdapter.MovieHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val holder =
            MovieHolder(LayoutInflater.from(mContext).inflate(R.layout.items_movie, parent, false))
        holder.itemView.setOnClickListener {
            mListner(listData[holder.adapterPosition])
        }
        return holder
    }

    inner class MovieHolder(view: View) : BaseHolder<Movie>(view) {
        val textRealese: TextView = view.date_movie
        val textTitle: TextView = view.title_movie
        val textRate = view.rate_movie
        val poster: ImageView = view.poster
        val textOverview = view.overview
        override fun bindData(data: Movie) {
            Glide.with(itemView.context).load("${BuildConfig.SMALL_PATH}${data.posterPath}")
                .into(poster)
            textTitle.text = data.title
            textRealese.text = data.realeseDate
            textRate.text = data.voteAverage.toString()
            textOverview.text = data.overview
        }
    }
}