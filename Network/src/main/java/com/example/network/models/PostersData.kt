package com.example.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostersData(
    @SerializedName("blurhash")
    val blurhash: String?,
    @SerializedName("240")
    val x240: String?
): Parcelable