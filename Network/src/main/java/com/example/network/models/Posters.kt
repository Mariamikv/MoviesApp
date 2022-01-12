package com.example.network.models


import com.google.gson.annotations.SerializedName

data class Posters(
    @SerializedName("data")
    val postersData: PostersData?
)