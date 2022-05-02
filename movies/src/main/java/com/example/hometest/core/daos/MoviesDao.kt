//package com.example.hometest.core.daos
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.Query
//import com.example.hometest.core.models.MoviesModel
//
//@Dao
//interface MoviesDao {
//    @Query("SELECT * FROM moviesmodel")
//    suspend fun getAllMovies(): List<MoviesModel>
//
//    @Insert
//    suspend fun insertMovies(vararg movies: MoviesModel)
//}