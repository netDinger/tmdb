package com.dinger.tmdbmovie.data.localDataSource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dinger.tmdbmovie.data.localDataSource.dao.MovieDao
import com.dinger.tmdbmovie.data.localDataSource.dao.WishListDao
import com.dinger.tmdbmovie.domain.model.Movie

@Database(
    entities = [(Movie::class)],
    version = 1, exportSchema = false
)
abstract class AppDB : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun wishDao(): WishListDao
}