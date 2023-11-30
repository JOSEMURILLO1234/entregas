package com.example.servigasv2.data.network


import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterface: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request =chain.request().newBuilder()
            .addHeader(
                "x-api-key", "QaHvyiKyGh1LZ5jtnBMIdFDb9f459cXapQiuzvTf",
            ).build()

        return chain.proceed(request)
    }
}