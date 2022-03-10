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

//    private val moviesData = MutableLiveData<List<MoviesModel>>().apply {
//        mutableListOf<List<MoviesModel>>()
//    }
//    val _moviesData: LiveData<List<MoviesModel>> = moviesData

    suspend fun getMovies(): LiveData<Movies>{
        movies = moviesRepository.getMoviesList()
        return movies
    }
//
//    fun read(){
//        viewModelScope.launch {
//            withContext(Dispatchers.IO){
//                moviesData.postValue(Database.db.moviesDao().getAllMovies())
//            }
//        }
//    }
//
//    fun writeEpisode(name: String?, description: String?, image: String?, imdb: String?){
//        val model = MoviesModel(name, description, image, imdb)
//        viewModelScope.launch {
//            withContext(Dispatchers.IO){
//                Database.db.moviesDao().insertMovies(model)
//            }
//        }
//    }
}