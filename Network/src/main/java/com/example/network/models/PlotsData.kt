package com.example.network.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlotsData(
    val description: String?,
    val language: String?
): Parcelable