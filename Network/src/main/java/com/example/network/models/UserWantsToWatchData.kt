package com.example.network.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserWantsToWatchData(
    val status: Boolean?
): Parcelable