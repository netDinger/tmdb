package com.dinger.tmdbmovie.data.localDataSource

import com.dinger.tmdbmovie.data.localDataSource.dao.WishListDao
import javax.inject.Inject

//Access dao via local data source
class WishListLocalDataSource @Inject constructor(
    private val wishListDao: WishListDao
)  {

     fun getWishList() = wishListDao.getWishList()
}