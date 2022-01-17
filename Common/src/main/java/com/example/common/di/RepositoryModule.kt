package com.example.common.di

import com.example.network.api.repository.MoviesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { MoviesRepository(get()) }
}