package com.example.network.models


import com.google.gson.annotations.SerializedName

data class UserWatch(
    @SerializedName("data")
    val userWatchData: UserWatchData?
)