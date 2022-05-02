package com.example.network.models


import com.google.gson.annotations.SerializedName

data class CoversData(
    @SerializedName("blurhash")
    val blurHash: String?,
    val imageHeight: Int?,
    val position: String?,
    val positionPercentage: String?,
    @SerializedName("1050")
    val x1050: String?,
    @SerializedName("145")
    val x145: String?,
    @SerializedName("1920")
    val x1920: String?,
    @SerializedName("367")
    val x367: String?,
    @SerializedName("510")
    val x510: String?
)