package com.example.network.api.request

import com.example.network.models.Movies
import com.example.network.models.moviesModels.PlayMovies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("api/v1/movies")
    suspend fun moviesList(): Response<Movies>

    @GET("api/v1/movies/{id}/season-files")
    suspend fun playMoviesList(@Path("id") id: Int): Response<PlayMovies>
}