package com.example.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rating(
    @SerializedName("imdb")
    val imdb: Imdb?,
    @SerializedName("imovies")
    val imovies: Imovies?,
    @SerializedName("metacritic")
    val metacritic: Metacritic?,
    @SerializedName("rotten")
    val rotten: Rotten?
): Parcelable