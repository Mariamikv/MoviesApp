package com.example.network.models


import com.google.gson.annotations.SerializedName

data class UserSubscribed(
    @SerializedName("data")
    val userSubscribedData: UserSubscribedData?
)