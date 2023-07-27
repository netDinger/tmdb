package com.dinger.tmdbmovie.data.localDataSource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dinger.tmdbmovie.domain.model.Movie
import com.dinger.tmdbmovie.domain.model.WishMovie

@Dao
interface WishListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieList(movies: List<WishMovie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: WishMovie)

    @Update
    fun updateMovie(movie: WishMovie)

    @Query("SELECT * FROM wishList WHERE id = :id_")
    fun getMovie(id_: Int): WishMovie

    @Query("SELECT * FROM wishList")
    fun getWishList(): List<WishMovie>
}