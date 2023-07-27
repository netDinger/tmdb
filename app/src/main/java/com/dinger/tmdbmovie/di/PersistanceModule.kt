package com.dinger.tmdbmovie.di

import android.content.Context
import androidx.room.Room
import com.dinger.tmdbmovie.data.localDataSource.AppDB
import com.dinger.tmdbmovie.data.localDataSource.dao.MovieDao
import com.dinger.tmdbmovie.data.localDataSource.dao.WishListDao


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideRoomDataBase(@ApplicationContext context: Context): AppDB {
        return Room
            .databaseBuilder(context, AppDB::class.java, "TheMovies.db")
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(appDatabase: AppDB): MovieDao {
        return appDatabase.movieDao()
    }

    @Provides
    @Singleton
    fun provideWishListDao(appDatabase: AppDB): WishListDao {
        return appDatabase.wishDao()
    }

}