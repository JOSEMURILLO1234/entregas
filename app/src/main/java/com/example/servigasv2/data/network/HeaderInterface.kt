package com.example.servigasv2.data.network


import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterface: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request =chain.request().newBuilder()
            .addHeader(
                "x-api-key", "bmRk4bxaF53seQxIRMYST6A11BQtrqdb5a92I6Hq",
            ).build()

        return chain.proceed(request)
    }
}