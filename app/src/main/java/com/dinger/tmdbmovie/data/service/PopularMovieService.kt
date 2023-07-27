package com.dinger.tmdbmovie.data.service

import com.dinger.tmdbmovie.domain.model.Movie
import com.dinger.tmdbmovie.domain.model.MovieListResponse

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PopularMovieService {
    @GET("/3/movie/popular")
    suspend operator fun invoke(): Response<MovieListResponse>

}

