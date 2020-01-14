package com.lintang.jetpackprolintang.base.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("original_title")
    var title: String? = null,
    @SerializedName("vote_average")
    var voteAverage: Double? = null,
    @SerializedName("release_date")
    var realeseDate: String? = null,
    @SerializedName("poster_path")
    var posterPath: String? = null,
    @SerializedName("backdrop_path")
    var backgroundPath: String? = null,
    @SerializedName("overview")
    var overview: String? = null
)