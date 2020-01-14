package com.lintang.jetpackprolintang.base.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class SeriesModel(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("original_name")
    val title: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("first_air_date")
    val realeseDate: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("backdrop_path")
    val backgroundPath: String?,
    val overview: String?
)