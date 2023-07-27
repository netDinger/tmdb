package com.dinger.tmdbmovie.domain.repository

import com.dinger.tmdbmovie.domain.model.Movie
import com.dinger.tmdbmovie.util.BaseResult

interface MovieDetailRepository {
    suspend fun getMovieDetails(id: Int): BaseResult<Movie>
}