package com.example.network.api.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.network.api.request.ApiService
import com.example.network.models.moviesModels.PlayMovies

class PlayMoviesRepository(private val apiService: ApiService) {
    suspend fun getMovie(id: Int): MutableLiveData<PlayMovies>{
        val movieLiveData = MutableLiveData<PlayMovies>().apply {
            mutableListOf<PlayMovies>()
        }
        val _movieLiveData: LiveData<PlayMovies> = movieLiveData

        val response = apiService.playMoviesList(id)
        if (response.isSuccessful){
            val items = response.body()
            movieLiveData.postValue(items)
        }
        return movieLiveData
    }
}