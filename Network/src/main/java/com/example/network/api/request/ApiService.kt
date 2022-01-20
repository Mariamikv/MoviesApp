package com.example.network.api.request

import com.example.network.models.Movies
import com.example.network.models.MoviesData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiService {
    @GET("api/v1/movies")
    suspend fun moviesList(): Response<Movies>
}