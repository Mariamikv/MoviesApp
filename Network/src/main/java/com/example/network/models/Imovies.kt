package com.example.network.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Imovies(
    val score: @RawValue Any?,
    val voters: Int?
): Parcelable