package com.dinger.tmdbmovie.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "wishList", primaryKeys = [("id")])
data class WishMovie(
                 @PrimaryKey(autoGenerate = false) val id: Int,
                 val title: String? = "",
                 val poster_path: String? = "",
                ) : Parcelable
