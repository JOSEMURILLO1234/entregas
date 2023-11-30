package com.example.servigasv2.core

import com.example.servigasv2.data.network.HeaderInterface
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitHelper {

    fun getRetrofit(): Retrofit {
        val UserInterceptor= OkHttpClient.Builder().addInterceptor(HeaderInterface()).build()
        return Retrofit.Builder()
            .baseUrl("https://1tbbi0l6cj.execute-api.us-east-1.amazonaws.com")
            .client(UserInterceptor)
            .addConverterFactory(MoshiConverterFactory.create(
                    Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                )
                )
            .build()
    }

}


