package com.example.network.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cover(
    val large: String?,
    val small: String?
):Parcelable