package com.dinger.tmdbmovie.data.repoImpl

import com.dinger.tmdbmovie.data.remoteDataSource.MovieListRemoteDataSource
import com.dinger.tmdbmovie.domain.model.Movie
import com.dinger.tmdbmovie.domain.repository.MovieListRepository
import com.dinger.tmdbmovie.util.BaseResult
import javax.inject.Inject

class MovieListRepositoryImpl @Inject constructor(private val dataSource: MovieListRemoteDataSource):MovieListRepository {
    override suspend fun getUpcomingMovies(): BaseResult<List<Movie>> {
        return dataSource.getUpcomingMovies()
    }

    override suspend fun getPopularMovies(): BaseResult<List<Movie>> {
        return dataSource.getPopularMovies()
    }


}