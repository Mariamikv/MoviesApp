package com.example.common.di

import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidApplication
import org.koin.core.scope.Scope
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CONNECT_TIMEOUT = 15L
private const val WRITE_TIMEOUT = 15L
private const val READ_TIMEOUT = 15L
private const val BASE_URL = "https://api.imovies.cc/"

val retrofitModule = module {
    single {
        Cache(androidApplication().cacheDir, 10L*1024*1024)
    }
    single {
        GsonBuilder().create()
    }
    single {
        retrofitHttpClient()
    }
    single {
        retrofitBuilder()
    }
    single(override = true) {
        OkHttpClient.Builder().addInterceptor(
            Interceptor { chain ->
                chain.proceed(chain.request().newBuilder().apply {
                    addHeader("User-Agent", "MoviesApp")
                }.build())
            }
        ).build()

    }
}

private fun Scope.retrofitBuilder(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(get())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun Scope.retrofitHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().apply {
        cache(get())
        connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        retryOnConnectionFailure(true)
        //addInterceptor(get())
        addInterceptor(HttpLoggingInterceptor().apply {
            level = if(BuildConfig.DEBUG){
                HttpLoggingInterceptor.Level.HEADERS
            }else{
                HttpLoggingInterceptor.Level.NONE
            }
        })
    }.build()
}