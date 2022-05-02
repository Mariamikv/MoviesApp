package com.example.network.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Imdb(
    val score: Double?,
    val voters: Int?
): Parcelable