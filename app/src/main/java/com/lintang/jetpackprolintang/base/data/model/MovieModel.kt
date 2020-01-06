package com.lintang.jetpackprolintang.base.data.model

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("id")
    val id: String?,
    @SerializedName("original_title")
    val title: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("release_date")
    val realeseDate: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("backdrop_path")
    val backgroundPath: String?,
    @SerializedName("overview")
    val overview: String?
)