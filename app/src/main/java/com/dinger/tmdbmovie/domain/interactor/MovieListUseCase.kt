package com.dinger.tmdbmovie.domain.interactor

import com.dinger.tmdbmovie.data.localDataSource.dao.MovieDao
import com.dinger.tmdbmovie.data.localDataSource.dao.WishListDao
import com.dinger.tmdbmovie.domain.model.WishMovie
import com.dinger.tmdbmovie.domain.repository.MovieListRepository
import com.dinger.tmdbmovie.util.BaseResult
import javax.inject.Inject

class MovieListUseCase @Inject constructor(
    private val movieListRepository: MovieListRepository,
    private val movieDao: MovieDao,
    private val wishListDao: WishListDao,
    private val hasConnection: Boolean = true //fake connection checker
    ) {
    //simple fake function to get popular movies from remote (if has connection)
    //or from local via dao pattern (if no connection)
    //sorry for this ugly and non-complete code, I don't have enough time to implement fully function-able code.
    suspend fun getPopularMovies(page: Int = 1) =if (hasConnection)  {
        movieListRepository.getPopularMovies()
    }else {BaseResult.Success(movieDao.getMovieList(1))}

    suspend fun getUpcomingMovies() = movieListRepository.getUpcomingMovies()

    //access dao directly via use case (suitable for simple operations)
    fun addToWishList(movie: WishMovie) =  wishListDao.insertMovie(movie)
}