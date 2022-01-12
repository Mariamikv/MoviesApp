package com.example.network.models


import com.google.gson.annotations.SerializedName

data class Covers(
    @SerializedName("data")
    val coversData: CoversData?
)