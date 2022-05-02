package com.example.network.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlotData(
    val description: String?,
    val language: String?
): Parcelable