package com.example.network.models.moviesModels


import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("columns")
    val columns: Int?,
    @SerializedName("duration")
    val duration: Int?,
    @SerializedName("end_time")
    val endTime: Int?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("interval")
    val interval: Int?,
    @SerializedName("start_time")
    val startTime: Int?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: Int?
)