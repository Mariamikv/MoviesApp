package com.example.network.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserFollowsData(
    val status: Boolean?
): Parcelable