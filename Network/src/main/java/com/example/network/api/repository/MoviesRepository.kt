package com.example.network.api.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.network.api.request.ApiService
import com.example.network.models.MoviesData
import kotlinx.coroutines.flow.Flow

class MoviesRepository(private val apiService: ApiService) {
//    suspend fun getMoviesList(): MutableLiveData<Movies>{
//        val moviesLiveData = MutableLiveData<Movies>().apply {
//            mutableListOf<Movies>()
//        }
//        val _moviesLiveData: LiveData<Movies> = moviesLiveData
//
//        val response = apiService.moviesList()
//        if (response.isSuccessful){
//            val items = response.body()
//            moviesLiveData.postValue(items)
//        }
//        return moviesLiveData
//    }

    fun getFetchData(): Flow<PagingData<MoviesData>>{
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = {
                MoviesPagingSource(apiService)
            }
        ).flow
    }
}