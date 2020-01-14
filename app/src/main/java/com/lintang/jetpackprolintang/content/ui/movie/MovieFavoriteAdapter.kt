package com.lintang.jetpackprolintang.content.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.lintang.jetpackprolintang.BuildConfig
import com.lintang.jetpackprolintang.R
import com.lintang.jetpackprolintang.base.data.source.local.entity.MovieEntity
import com.lintang.jetpackprolintang.base.ui.BaseAdapter
import com.lintang.jetpackprolintang.base.ui.BaseHolder
import com.lintang.jetpackprolintang.base.utils.Helper.Func.toDatetoString
import kotlinx.android.synthetic.main.items_movie.view.*

class MovieFavoriteAdapter :
    BaseAdapter<MovieEntity, MovieFavoriteAdapter.MovieHolder>(
        ITEM_CALLBACK
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val holder =
            MovieHolder(LayoutInflater.from(mContext).inflate(R.layout.items_movie, parent, false))
        holder.itemView.setOnClickListener {
            mListner(getItem(holder.adapterPosition))
        }
        return holder
    }

    inner class MovieHolder(view: View) : BaseHolder<MovieEntity>(view) {
        val textRealese: TextView = view.date_movie
        val textTitle: TextView = view.title_movie
        val textRate = view.rate_movie
        val poster: ImageView = view.poster
        val textOverview = view.overview
        override fun bindData(data: MovieEntity?) {
            Glide.with(itemView.context).load("${BuildConfig.SMALL_PATH}${data?.posterPath}")
                .into(poster)
            textTitle.text = data?.title
            textRealese.text = toDatetoString(data?.realeseDate ?: "", "EEE, dd MMM yyyy")
            textRate.text = data?.voteAverage.toString()
            textOverview.text = data?.overview
        }
    }

    companion object {
        private val ITEM_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.equals(newItem)
            }

        }
    }
}