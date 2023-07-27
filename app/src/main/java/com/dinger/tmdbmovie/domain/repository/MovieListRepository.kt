package com.dinger.tmdbmovie.domain.repository

import com.dinger.tmdbmovie.domain.model.Movie
import com.dinger.tmdbmovie.util.BaseResult

interface MovieListRepository {
    suspend fun getUpcomingMovies(): BaseResult<List<Movie>>
    suspend fun getPopularMovies(): BaseResult<List<Movie>>


}