package com.example.network.api.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.network.api.request.ApiService
import com.example.network.models.Movies

class MoviesRepository(private val apiService: ApiService) {
    suspend fun getMoviesList(): MutableLiveData<Movies>{
        val moviesLiveData = MutableLiveData<Movies>().apply {
            mutableListOf<Movies>()
        }
        val _moviesLiveData: LiveData<Movies> = moviesLiveData

        val response = apiService.moviesList()
        if (response.isSuccessful){
            val items = response.body()
            moviesLiveData.postValue(items)
        }
        return moviesLiveData
    }
}