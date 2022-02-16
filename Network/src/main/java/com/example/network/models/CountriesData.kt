package com.example.network.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountriesData(
    val id: Int?,
    val primaryName: String?,
    val secondaryName: String?,
    val tertiaryName: String?
): Parcelable