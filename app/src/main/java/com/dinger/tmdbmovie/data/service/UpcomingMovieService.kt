package com.dinger.tmdbmovie.data.service

import com.dinger.tmdbmovie.domain.model.Movie
import com.dinger.tmdbmovie.domain.model.MovieListResponse

import retrofit2.Response
import retrofit2.http.GET


interface UpcomingMovieService {
    @GET("/3/movie/upcoming")
    suspend operator fun invoke() : Response<MovieListResponse>

}
