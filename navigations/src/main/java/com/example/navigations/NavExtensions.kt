package com.example.navigations

import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions

fun buildDeepLink(destination: DeepLinkDestination) =
    NavDeepLinkRequest.Builder
        .fromUri(destination.address.toUri())
        .build()

fun NavController.deepLinkNavigateTo(
    deepLinkDestination: DeepLinkDestination,
    popUpTo: Boolean = false
) {
    val builder = NavOptions.Builder()

    if (popUpTo) {
        builder.setPopUpTo(graph.startDestinationId, true)
    }

    navigate(
        buildDeepLink(deepLinkDestination),
        builder.build()
    )
}

// change for movies_details fragment
sealed class DeepLinkDestination(val address: String) {
    class moviesDetails(msg: String) : DeepLinkDestination("example://dashboard/exampleArgs?msg=${msg}")
    object Next : DeepLinkDestination("example://next")
}