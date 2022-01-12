package com.example.network.models


import com.google.gson.annotations.SerializedName

data class Countries(
    @SerializedName("data")
    val countriesData: List<CountriesData>?
)