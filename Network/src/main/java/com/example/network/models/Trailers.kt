package com.example.network.models


import com.google.gson.annotations.SerializedName

data class Trailers(
    @SerializedName("data")
    val trailersData: List<TrailersData>?
)