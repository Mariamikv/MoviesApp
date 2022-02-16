package com.example.network.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Metacritic(
    val score: Int?,
    val voters: @RawValue Any?
): Parcelable