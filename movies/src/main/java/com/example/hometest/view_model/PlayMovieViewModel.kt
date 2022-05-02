package com.example.hometest.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.network.api.repository.PlayMoviesRepository
import com.example.network.models.moviesModels.PlayMovies

class PlayMovieViewModel(private val playMoviesRepository: PlayMoviesRepository): ViewModel() {
    var playMovie = MutableLiveData<PlayMovies>()

    suspend fun playMovie(id: Int): LiveData<PlayMovies>{
        playMovie = playMoviesRepository.getMovie(id)
        return playMovie
    }
}