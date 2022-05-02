package com.example.network.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LanguagesData(
    val code: String?,
    val primaryName: String?,
    val primaryNameTurned: String?,
    val secondaryName: String?,
    val tertiaryName: String?
):Parcelable