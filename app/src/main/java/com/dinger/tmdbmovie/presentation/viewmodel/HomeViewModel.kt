package com.dinger.tmdbmovie.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinger.tmdbmovie.domain.interactor.MovieListUseCase
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
 * I have to skip ui mapper and ui model for now. Because I don't have enough time to do it.
 * I have only total coding time of ~3 hours for this project(including all setup). Because of my office's urgent tasks.
 *
 * Although I should use pagination for now, I have to implement it later.
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieListUseCase: MovieListUseCase,
) : ViewModel() {

    private val _popularMoviesState = MutableStateFlow<ViewState<List<Movie>>>(ViewState.Loading)
    val popularMoviesState: StateFlow<ViewState<List<Movie>>> = _popularMoviesState //immutable state flow

    private val _upcomingMoviesState = MutableStateFlow<ViewState<List<Movie>>>(ViewState.Loading)
    val upcomingMoviesState: StateFlow<ViewState<List<Movie>>> = _upcomingMoviesState //immutable state flow


    fun getPopularMovies() {

        _popularMoviesState.value = ViewState.Loading
        viewModelScope.launch {
            when (val result = movieListUseCase.getPopularMovies()){
                is BaseResult.Success<List<Movie>> ->
                    //TODO: add ui mapper and map into ui model
                    _popularMoviesState.value = ViewState.Success(result.data)
                is BaseResult.Failure -> {_popularMoviesState.value =  ViewState.Error(result.error)}
            }
        }
    }

    fun getUpcomingMovies() {
        _upcomingMoviesState.value = ViewState.Loading
        viewModelScope.launch {
            when (val result = movieListUseCase.getUpcomingMovies()){
                is BaseResult.Success<List<Movie>> ->

                    //TODO: add ui mapper and map into ui model
                    _upcomingMoviesState.value = ViewState.Success(result.data)
                is BaseResult.Failure -> {_upcomingMoviesState.value =  ViewState.Error(result.error)}
            }
        }
    }

    //Since adding to wishlist is done only in local storage and it is quite simple,
    // I run this on main thread without using any callback and listener.
    fun addToWishList(movie: Movie){
        movieListUseCase.addToWishList(WishMovie(movie.id, movie.title ?: "", movie.poster_path ?: ""))
    }



}