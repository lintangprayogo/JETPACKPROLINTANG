package com.lintang.jetpackprolintang.base.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "series_table")
data class SeriesEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int? = null,
    @ColumnInfo(name = "series_title")
    var title: String? = null,
    @ColumnInfo(name = "vote_average")
    var voteAverage: Double? = null,
    @ColumnInfo(name = "first_air_date")
    var firstAirDate: String? = null,
    @ColumnInfo(name = "poster_path")
    var posterPath: String? = null,
    @ColumnInfo(name = "backdrop_path")
    var backgroundPath: String? = null,
    @ColumnInfo(name = "overview")
    var overview: String? = null,
    @ColumnInfo(name = "favorite")
    var favorite: Boolean
)