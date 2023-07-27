package com.dinger.tmdbmovie.data.repoImpl

import com.dinger.tmdbmovie.data.remoteDataSource.MovieDetailRemoteDataSource
import com.dinger.tmdbmovie.domain.model.Movie
import com.dinger.tmdbmovie.domain.repository.MovieDetailRepository
import com.dinger.tmdbmovie.util.BaseResult
import javax.inject.Inject

class MovieDetailRepoImpl @Inject constructor(
    private val movieDetailRemoteDataSource: MovieDetailRemoteDataSource
): MovieDetailRepository {
    override suspend fun getMovieDetails(id: Int): BaseResult<Movie> {
        return movieDetailRemoteDataSource.getMovieDetails(id)
    }
}