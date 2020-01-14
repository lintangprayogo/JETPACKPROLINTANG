package com.lintang.jetpackprolintang.base.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lintang.jetpackprolintang.base.data.source.local.entity.MovieEntity
import com.lintang.jetpackprolintang.base.data.source.local.entity.SeriesEntity

@Database(
    entities = arrayOf(MovieEntity::class, SeriesEntity::class),
    version = 1,
    exportSchema = false
)
abstract class MovieSeriesDatabase : RoomDatabase() {
    abstract fun movieSeriesDao(): MovieSeriesDao

    companion object {
        @Volatile
        private var INSTANCE: MovieSeriesDatabase? = null
        private val sLock = Any()

        fun getDatabase(context: Context): MovieSeriesDatabase {
            synchronized(sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MovieSeriesDatabase::class.java,
                        "movie_database.db"
                    ).build()

                }
                return INSTANCE!!
            }
        }

    }


}