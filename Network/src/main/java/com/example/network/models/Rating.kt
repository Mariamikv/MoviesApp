package com.example.network.models


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("imdb")
    val imdb: Imdb?,
    @SerializedName("imovies")
    val imovies: Imovies?,
    @SerializedName("metacritic")
    val metacritic: Metacritic?,
    @SerializedName("rotten")
    val rotten: Rotten?
)