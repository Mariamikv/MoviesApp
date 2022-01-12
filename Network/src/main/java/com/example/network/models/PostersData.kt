package com.example.network.models


import com.google.gson.annotations.SerializedName

data class PostersData(
    @SerializedName("blurhash")
    val blurhash: String?,
    @SerializedName("240")
    val x240: String?
)