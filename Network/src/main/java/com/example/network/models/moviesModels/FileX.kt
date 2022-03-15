package com.example.network.models.moviesModels


import com.google.gson.annotations.SerializedName

data class FileX(
    @SerializedName("duration")
    val duration: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("quality")
    val quality: String?,
    @SerializedName("src")
    val src: String?,
    @SerializedName("thumbnails")
    val thumbnails: List<Thumbnail>?
)