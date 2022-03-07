package com.example.navigations

import androidx.navigation.NavController

class Navigator {
    lateinit var navController: NavController

     //navigate on main thread or nav component crashes sometimes
    fun navigateToFlow(navigationFlow: NavigationFlow) = when (navigationFlow) {
        NavigationFlow.moviesFlow-> navController.navigate(MainNavGraphDirections.actionGlobalMoviesFlow())
        // change
       // is NavigationFlow.moviesDetailsdFlow -> navController.navigate(MainNavGraphDirections.actionGlobalMoviesDetailsFlow(navigationFlow.msg))
    }
}