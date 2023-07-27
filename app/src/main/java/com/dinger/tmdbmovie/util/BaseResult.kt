package com.dinger.tmdbmovie.util


sealed class BaseResult<out T> {
    data class Success<T>(val data: T) : BaseResult<T>()
    data class Failure(val error: Exception) : BaseResult<Nothing>()
}
