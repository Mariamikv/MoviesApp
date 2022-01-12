package com.example.network.models


import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("data")
    val moviesData: List<MoviesData>?,
    val meta: Meta?
)