package com.lintang.jetpackprolintang.ui.series

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
import com.lintang.jetpackprolintang.data.Series
import kotlinx.android.synthetic.main.items_series.view.*

class SeriesAdapter : BaseAdapter<Series, SeriesAdapter.SeriesHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesHolder {
        val holder = SeriesHolder(
            LayoutInflater.from(mContext).inflate(
                R.layout.items_series,
                parent,
                false
            )
        )
        holder.itemView.setOnClickListener {
            mListner(listData[holder.adapterPosition])
        }
        return holder
    }

    inner class SeriesHolder(view: View) : BaseHolder<Series>(view) {
        val textRealese: TextView = view.date_series
        val textTitle: TextView = view.title_series
        val textRate = view.rate_series
        val poster: ImageView = view.poster
        val textOverview = view.overview
        override fun bindData(data: Series) {
            Glide.with(itemView.context).load("${BuildConfig.SMALL_PATH}${data.posterPath}")
                .into(poster)
            textTitle.text = data.title
            textRealese.text = data.realeseDate
            textRate.text = data.voteAverage.toString()
            textOverview.text = data.overview
        }
    }
}