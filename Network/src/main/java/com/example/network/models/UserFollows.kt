package com.example.network.models


import com.google.gson.annotations.SerializedName

data class UserFollows(
    @SerializedName("data")
    val userFollowsData: UserFollowsData?
)