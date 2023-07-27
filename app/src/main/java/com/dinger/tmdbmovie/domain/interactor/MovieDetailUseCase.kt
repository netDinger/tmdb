package com.dinger.tmdbmovie.domain.interactor

import com.dinger.tmdbmovie.data.localDataSource.dao.WishListDao
import com.dinger.tmdbmovie.domain.model.WishMovie
import com.dinger.tmdbmovie.domain.repository.MovieDetailRepository
import javax.inject.Inject

class MovieDetailUseCase @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository,
    private val wishListDao: WishListDao) {

    suspend fun getMovieDetail(id: Int) = movieDetailRepository.getMovieDetails(id)

    fun addToWishList(movie: WishMovie) =  wishListDao.insertMovie(movie)
}