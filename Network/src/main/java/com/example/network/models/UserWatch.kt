package com.example.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserWatch(
    @SerializedName("data")
    val userWatchData: UserWatchData?
): Parcelable