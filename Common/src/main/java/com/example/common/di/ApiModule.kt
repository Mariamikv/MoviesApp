package com.example.common.di

import com.example.network.api.request.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single(createdAtStart = false) {
        get<Retrofit>().create(ApiService::class.java)
    }
}