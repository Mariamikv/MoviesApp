package com.example.network.models


import com.google.gson.annotations.SerializedName

data class Plots(
    @SerializedName("data")
    val plotsData: List<PlotsData>?
)