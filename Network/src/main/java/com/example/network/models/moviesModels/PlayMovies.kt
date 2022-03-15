package com.example.network.models.moviesModels


import com.google.gson.annotations.SerializedName

data class PlayMovies(
    @SerializedName("data")
    val `data`: List<Data>?
)