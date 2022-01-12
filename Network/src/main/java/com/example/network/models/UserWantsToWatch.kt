package com.example.network.models


import com.google.gson.annotations.SerializedName

data class UserWantsToWatch(
    @SerializedName("data")
    val userWantsToWatchData: UserWantsToWatchData?
)