package com.lintang.jetpackprolintang.base.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    open fun bindData(data: T) {

    }
}