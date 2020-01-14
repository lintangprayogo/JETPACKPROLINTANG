package com.lintang.jetpackprolintang.base.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class BaseApiModel<T>(
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: T? = null,

    var page: Int,
    var total_results: Int,
    var total_pages: Int,
    var results: T? = null
)