package com.example.servigasv2.data.network

import com.example.servigasv2.data.model.clienteModel.UserDataPost
import com.example.servigasv2.data.model.clienteModel.clientModel
import com.example.servigasv2.data.model.orderModel.OrderModel
import com.example.servigasv2.data.model.orderModel.OrderPost
import com.example.servigasv2.data.model.repartidorModel.bodyPost
import com.example.servigasv2.model.deliverModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserInterface {
    @GET("/version2/version2/driver")
    suspend fun getAllDeliver():Response<deliverModel>

    @POST("/version2/version2/driver")
    suspend fun postDatDeliv(@Body formDataDeliver: bodyPost): Response<*>

    @GET("/version2/version2/aclient")
    suspend fun getAllClient():Response<clientModel>

    @POST("/version2/version2/aclient")
    suspend fun postDatClient(@Body formData: UserDataPost): Response<*>

    @GET("/version2/version2/order")
    suspend fun getAllOrder():Response<OrderModel>
    @POST("/version2/version2/order")
    suspend fun postDatOrder(@Body formDataOrder: OrderPost): Response<*>
}