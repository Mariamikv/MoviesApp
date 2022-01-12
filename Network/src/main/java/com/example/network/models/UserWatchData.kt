package com.example.network.models


import com.google.gson.annotations.SerializedName

data class UserWatchData(
    @SerializedName("duration")
    val duration: Int?,
    @SerializedName("episode")
    val episode: Any?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("progress")
    val progress: Int?,
    @SerializedName("quality")
    val quality: String?,
    @SerializedName("season")
    val season: Any?,
    @SerializedName("updateDate")
    val updateDate: String?,
    @SerializedName("visible")
    val visible: Boolean?,
    @SerializedName("watched")
    val watched: Boolean?
)