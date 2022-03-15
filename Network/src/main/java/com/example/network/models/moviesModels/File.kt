package com.example.network.models.moviesModels


import com.google.gson.annotations.SerializedName

data class File(
    @SerializedName("files")
    val files: List<FileX>?,
    @SerializedName("lang")
    val lang: String?,
    @SerializedName("subtitles")
    val subtitles: List<Subtitle>?
)