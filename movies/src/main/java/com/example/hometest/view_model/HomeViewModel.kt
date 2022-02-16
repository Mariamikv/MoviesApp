package com.example.hometest.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.api.repository.MoviesRepository
import com.example.network.models.Movies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val moviesRepository: MoviesRepository): ViewModel() {
    var movies = MutableLiveData<Movies>()

    suspend fun getMovies(): LiveData<Movies>{
        movies = moviesRepository.getMoviesList()
        return movies
    }
}