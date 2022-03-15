package com.example.network.models.moviesModels


import com.google.gson.annotations.SerializedName

data class Subtitle(
    @SerializedName("lang")
    val lang: String?,
    @SerializedName("url")
    val url: String?
)