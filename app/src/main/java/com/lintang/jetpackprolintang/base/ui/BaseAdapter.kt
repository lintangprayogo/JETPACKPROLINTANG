package com.lintang.jetpackprolintang.base.ui

import android.content.Context
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil

abstract class BaseAdapter<T, Holder : BaseHolder<T>>(callback: DiffUtil.ItemCallback<T>) :
    PagedListAdapter<T, Holder>(callback) {
    protected var mLayout: Int = 0
    protected lateinit var mContext: Context
    protected lateinit var mListner: (T?) -> Unit


    fun setLayout(mContext: Context, mLayout: Int) {
        this.mContext = mContext
        this.mLayout = mLayout
    }


    fun setListner(mListner: (T?) -> Unit) {
        this.mListner = mListner
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindData(getItem(position))
    }


}