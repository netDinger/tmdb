package com.dinger.tmdbmovie.data.localDataSource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dinger.tmdbmovie.domain.model.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieList(movies: List<Movie>)

    @Update
    fun updateMovie(movie: Movie)

    @Query("SELECT * FROM movies WHERE id = :id_")
    fun getMovie(id_: Int): Movie

    @Query("SELECT * FROM movies WHERE page = :page_")
    fun getMovieList(page_: Int): List<Movie>
}