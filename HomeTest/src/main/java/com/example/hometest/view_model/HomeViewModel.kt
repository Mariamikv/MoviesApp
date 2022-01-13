package com.example.hometest.view_model

import androidx.lifecycle.ViewModel
import com.example.network.api.repository.MoviesRepository

class HomeViewModel(private val moviesRepository: MoviesRepository): ViewModel() {
}