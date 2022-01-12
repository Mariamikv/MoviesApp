package com.example.network.models


import com.google.gson.annotations.SerializedName

data class Languages(
    @SerializedName("data")
    val languagesData: List<LanguagesData>?
)