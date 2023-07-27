package com.dinger.tmdbmovie.domain.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


data class MovieListResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int,
)


//also used for both local dao model and network response model
//Since the api return values can be null(we don't know too much about the api), we need to use nullable
@Parcelize
@Entity(tableName = "movies", primaryKeys = [("id")])
data class Movie(
                 @PrimaryKey(autoGenerate = false) val id: Int,
                 val title: String? = "",
                 val poster_path: String? = "",
                 val adult: Boolean? = false,
                 val overview: String? = "",
                 val release_date: String? = "",
                 val genre_ids: List<Int> = emptyList(),
                 val original_title: String? = "",
                 val original_language: String? = "",
                 val backdrop_path: String? = "",
                 val popularity: Float? = 0f,
                 val vote_count: Int? = 0,
                 var page: Int,
                 val video: Boolean? = false,
                 val vote_average: Float? = 0f,
                 ) : Parcelable


