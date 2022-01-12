package com.example.network.api.request

import com.example.network.models.Movies
import com.example.network.models.MoviesData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/v1/movies?page=2&per_page=15&filters%5Bgenres_related%5D=no&filters%5Bcountries_related%5D=no&filters%5Btype%5D=movie&filters%5Bwithout_watched_movies%5D=no&filters%5Bwith_files%5D=yes&sort=-upload_date")
    suspend fun moviesList(): Response<List<Movies>>
}