package com.example.common.di

import com.example.hometest.view_model.HomeViewModel
import com.example.hometest.view_model.PlayMovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { PlayMovieViewModel(get()) }
}