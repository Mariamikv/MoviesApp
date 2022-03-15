package com.example.common.di

import com.example.network.api.repository.MoviesRepository
import com.example.network.api.repository.PlayMoviesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { MoviesRepository(get()) }
    single { PlayMoviesRepository(get()) }
}