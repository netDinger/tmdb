package com.dinger.tmdbmovie.data.remoteDataSource

import android.util.Log
import com.dinger.tmdbmovie.data.localDataSource.dao.MovieDao
import com.dinger.tmdbmovie.data.service.PopularMovieService
import com.dinger.tmdbmovie.data.service.UpcomingMovieService
import com.dinger.tmdbmovie.domain.model.Movie
import com.dinger.tmdbmovie.util.BaseResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class MovieListRemoteDataSource @Inject constructor(
    private val popularMovieService: PopularMovieService,
    private val upcomingMovieService: UpcomingMovieService,
    private val movieDao: MovieDao,
) {

    suspend fun getPopularMovies(): BaseResult<List<Movie>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = popularMovieService()
                if (response.isSuccessful) {
                    response.body()?.let { movies ->
                        movieDao.insertMovieList(movies.results)
                        BaseResult.Success(movies.results) }
                        ?: BaseResult.Failure(Exception("Error Mapping Response"))

                } else
                    BaseResult.Failure(Exception("Error With"+response.code()+response.message()))
            }catch (e: Exception) {
                Log.e("MovieRemoteDataSource", "getPopularMovies: ${e.message}")
                BaseResult.Failure(e)
            }
        }
    }

    suspend fun getUpcomingMovies(): BaseResult<List<Movie>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = upcomingMovieService()

                if (response.isSuccessful) {
                    response.body()?.let { movies ->
                        movieDao.insertMovieList(movies.results)
                        BaseResult.Success(movies.results) }
                        ?: BaseResult.Failure(Exception("Error Mapping Response"))

                } else
                    BaseResult.Failure(Exception("Error With"+response.code()+response.message()))
            }catch (e: Exception) {
                Log.e("MovieRemoteDataSource", "getUpcomingMovies: ${e.message}")
                BaseResult.Failure(e)
            }
        }
    }


}