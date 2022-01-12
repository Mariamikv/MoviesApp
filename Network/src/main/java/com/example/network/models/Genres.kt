package com.example.network.models


import com.google.gson.annotations.SerializedName

data class Genres(
    @SerializedName("data")
    val genresData: List<GenresData>?
)