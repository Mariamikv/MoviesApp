package com.example.network.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserSubscribedData(
    val status: Boolean?
): Parcelable