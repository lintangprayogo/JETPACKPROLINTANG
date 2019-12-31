package com.lintang.jetpackprolintang.base.ui

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, Holder : BaseHolder<T>> : RecyclerView.Adapter<Holder>() {
    protected val listData: MutableList<T> = mutableListOf()
    protected var mLayout: Int = 0
    protected lateinit var mContext: Context
    protected lateinit var mListner: (T) -> Unit


    fun setLayout(mContext: Context, mLayout: Int) {
        this.mContext = mContext
        this.mLayout = mLayout
    }

    fun setData(entries: List<T>) {
        listData.addAll(entries)
        notifyDataSetChanged()
    }

    fun setListner(mListner: (T) -> Unit) {
        this.mListner = mListner
    }


    fun destroyData() {
        listData.clear()
    }


    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindData(listData[position])
    }
}