package com.dinger.tmdbmovie.di

import com.dinger.tmdbmovie.data.repoImpl.MovieDetailRepoImpl
import com.dinger.tmdbmovie.data.repoImpl.MovieListRepositoryImpl
import com.dinger.tmdbmovie.domain.model.MovieDetail
import com.dinger.tmdbmovie.domain.repository.MovieDetailRepository
import com.dinger.tmdbmovie.domain.repository.MovieListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieModule {

    @Binds
    abstract fun bindMovieRepository(movieRepositoryImpl: MovieListRepositoryImpl): MovieListRepository

    @Binds
    abstract fun bindMovieDetailRepository(movieDetailRepositoryImpl: MovieDetailRepoImpl): MovieDetailRepository
}