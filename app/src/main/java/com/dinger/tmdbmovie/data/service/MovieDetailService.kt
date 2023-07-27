package com.dinger.tmdbmovie.data.service

import com.dinger.tmdbmovie.domain.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetailService {
    @GET("/3/movie/{movie_id}")
    suspend operator fun invoke(@Path("movie_id") id: Int): Response<Movie>

}