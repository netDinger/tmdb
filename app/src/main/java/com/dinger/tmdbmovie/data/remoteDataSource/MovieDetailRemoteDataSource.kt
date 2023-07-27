package com.dinger.tmdbmovie.data.remoteDataSource

import android.util.Log
import com.dinger.tmdbmovie.data.service.MovieDetailService
import com.dinger.tmdbmovie.domain.model.Movie
import com.dinger.tmdbmovie.util.BaseResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieDetailRemoteDataSource @Inject constructor(
    private val movieDetailService: MovieDetailService) {


    suspend fun getMovieDetails(id: Int): BaseResult<Movie> {
        return withContext(Dispatchers.IO) {
            try {
                val response = movieDetailService(id)
                if (response.isSuccessful) {
                    response.body()?.let { movie -> BaseResult.Success(movie) }
                        ?: BaseResult.Failure(Exception("Error Mapping Response"))

                } else
                    BaseResult.Failure(Exception("Error With"+response.code()+response.message()))
            }catch (e: Exception) {
                Log.e("MovieRemoteDataSource", "getMovieDetail: ${e.message}")
                BaseResult.Failure(e)
            }
        }
    }
}