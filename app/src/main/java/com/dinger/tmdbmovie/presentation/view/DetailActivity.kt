package com.dinger.tmdbmovie.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.dinger.tmdbmovie.R
import com.dinger.tmdbmovie.domain.model.Movie
import com.dinger.tmdbmovie.presentation.viewmodel.DetailViewModel
import com.dinger.tmdbmovie.util.ViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailActivity: AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModels()
    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //get the movie id from the intent passed to this activity
        val id = intent.getIntExtra("id", 0)

        viewModel.getMovieDetail(id)

        observeMovieDetail()


    }

    private fun observeMovieDetail() {
        lifecycleScope.launch {
            viewModel.movieDetailState.collect{
                when(it) {
                    is ViewState.Error -> showError(it.error.message ?: "Unknown Error")
                    ViewState.Loading -> showLoading()
                    ViewState.NoData -> showNoData()
                    is ViewState.Success -> {
                        movie = it.data
                        renderMovieDetail(it.data)}
                }
            }
        }
    }

    //Call this function to add the movie to the wish list
    private fun addToWishList(movie: Movie) {
        viewModel.addToWishList(movie)
    }

    private fun showLoading(){
        Log.e("DetailActivity", "loading...")
    }

    private fun showError(message: String){
        Log.e("DetailActivity", message)
    }

    private fun showNoData(){
        //TODO handle no data view
    }

    private fun renderMovieDetail(movie: Movie) {
        Log.e("DetailActivity",movie.toString())
    }

}