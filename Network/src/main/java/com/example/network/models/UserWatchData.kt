package com.example.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class UserWatchData(
    @SerializedName("duration")
    val duration: Int?,
    @SerializedName("episode")
    val episode: @RawValue Any?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("progress")
    val progress: Int?,
    @SerializedName("quality")
    val quality: String?,
    @SerializedName("season")
    val season: @RawValue Any?,
    @SerializedName("updateDate")
    val updateDate: String?,
    @SerializedName("visible")
    val visible: Boolean?,
    @SerializedName("watched")
    val watched: Boolean?
): Parcelable