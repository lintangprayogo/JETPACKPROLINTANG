package com.lintang.jetpackprolintang.base.data.source

interface LoadCallback<T> {
    fun onDataReceived(data: T)
    fun onDataNotAvailble(msg: String)
}