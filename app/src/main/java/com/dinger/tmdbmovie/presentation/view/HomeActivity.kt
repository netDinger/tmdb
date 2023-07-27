package com.dinger.tmdbmovie.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.dinger.tmdbmovie.R
import com.dinger.tmdbmovie.domain.model.Movie
import com.dinger.tmdbmovie.domain.model.WishMovie
import com.dinger.tmdbmovie.presentation.viewmodel.HomeViewModel
import com.dinger.tmdbmovie.util.ViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()
    private var upcomingMovies: List<Movie> = emptyList()
    private var popularMovies: List<Movie> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //fetch data
        viewModel.getPopularMovies()
        viewModel.getUpcomingMovies()
        //observe data
        observePopularMovies()
        observeUpcomingMovies()

        findViewById<Button>(R.id.c).setOnClickListener {
            //Adding to wishlist example
            addToWishList(upcomingMovies[0])

            //route to detail activity
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("id", upcomingMovies[0].id ) //fake id for showing detail
            startActivity(intent)
        }
    }

   private fun observePopularMovies(){
        lifecycleScope.launch {
            viewModel.popularMoviesState.collect{
                when (it) {
                    is ViewState.Loading -> showLoading()
                    is ViewState.Error -> showError(it.error.message ?: "Error")
                    is ViewState.NoData -> showNoData()
                    is ViewState.Success ->{
                        popularMovies = it.data
                        renderPopularMovies(it.data)
                    }
                }
            }


        }
    }

    private fun observeUpcomingMovies(){
        lifecycleScope.launch {
            viewModel.upcomingMoviesState.collect{
                when (it) {
                    is ViewState.Loading -> showLoading()
                    is ViewState.Error -> showError(it.error.message?: "Unknown Error")
                    is ViewState.NoData -> showNoData()
                    is ViewState.Success -> {
                        upcomingMovies = it.data
                        renderUpcomingMovies(it.data)}
                }
            }
        }
    }

    private fun addToWishList(movie: Movie) {
        viewModel.addToWishList(movie)
    }



    private fun showLoading(){
        Log.e("HomeActivity", "loading...")
    }

    private fun showError(message: String){
        Log.e("HomeActivity", message)
    }

    private fun showNoData(){
        //TODO handle no data view
    }

    private fun renderPopularMovies(popularMovies: List<Movie>){
        //TODO handle popular movies view

        Log.e("Popular Movies", popularMovies.toString())
    }

    private fun renderUpcomingMovies(upcomingMovies: List<Movie>){
        //TODO render upcoming movies
        Log.e("Upcoming Movies", upcomingMovies.toString())
    }
}