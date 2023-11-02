package com.example.servigasv2.data.network

import com.example.servigasv2.model.body
import com.example.servigasv2.model.deliverModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface deliverInterface {

    @GET("/version1/driver")
    suspend fun getAllDeliver():Response<deliverModel>
}