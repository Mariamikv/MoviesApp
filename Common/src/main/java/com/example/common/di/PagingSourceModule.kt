package com.example.common.di

import com.example.network.api.repository.MoviesPagingSource
import org.koin.dsl.module

val pagingSourceModule = module {
    single { MoviesPagingSource(get()) }
}