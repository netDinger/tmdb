package com.dinger.tmdbmovie.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinger.tmdbmovie.domain.interactor.MovieDetailUseCase

import com.dinger.tmdbmovie.domain.model.Movie
import com.dinger.tmdbmovie.domain.model.WishMovie
import com.dinger.tmdbmovie.util.BaseResult
import com.dinger.tmdbmovie.util.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * I have to skip ui model mapper and ui model because I don't have enough time to do it.
 *
 */
@HiltViewModel
class DetailViewModel @Inject constructor(
    private val movieDetailUseCase: MovieDetailUseCase
): ViewModel() {
    private val _movieDetailState = MutableStateFlow<ViewState<Movie>>(ViewState.Loading)
    val movieDetailState: StateFlow<ViewState<Movie>> = _movieDetailState //immutable state flow


    fun getMovieDetail(id: Int) {
        _movieDetailState.value = ViewState.Loading
        viewModelScope.launch {
            when (val result = movieDetailUseCase.getMovieDetail(id)){
                is BaseResult.Success<Movie> ->
                    //TODO: add ui mapper and map into ui model
                    _movieDetailState.value = ViewState.Success(result.data)
                is BaseResult.Failure -> {_movieDetailState.value =  ViewState.Error(result.error)}
            }
        }
    }

    fun addToWishList(movie: Movie){
        movieDetailUseCase.addToWishList(WishMovie(movie.id, movie.title ?: "", movie.poster_path ?: ""))
    }
}