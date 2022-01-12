package com.example.network.models


import com.google.gson.annotations.SerializedName

data class Plot(
    @SerializedName("data")
    val plotData: PlotData?
)