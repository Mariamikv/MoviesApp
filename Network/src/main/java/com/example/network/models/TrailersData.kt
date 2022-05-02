package com.example.network.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TrailersData(
    val fileUrl: String?,
    val id: Int?,
    val language: String?,
    val name: String?
): Parcelable