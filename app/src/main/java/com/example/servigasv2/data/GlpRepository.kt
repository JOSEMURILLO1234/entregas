package com.example.servigasv2.data

import com.example.servigasv2.DeliverProvider
import com.example.servigasv2.data.model.clienteModel.ClientProvier
import com.example.servigasv2.data.model.clienteModel.UserData
import com.example.servigasv2.data.model.clienteModel.UserDataPost
import com.example.servigasv2.data.model.clienteModel.clientModel
import com.example.servigasv2.data.model.orderModel.Order
import com.example.servigasv2.data.model.orderModel.OrderPost
import com.example.servigasv2.data.model.orderModel.OrderProvider
import com.example.servigasv2.data.model.repartidorModel.bodyPost
import com.example.servigasv2.data.network.GlpService
import com.example.servigasv2.model.body

class GlpRepository {
    private val api = GlpService()

    suspend fun getAllResponse(): List<body> {
        val response = api.getDeliver()
        DeliverProvider.deliver = response
        return response
    }

    suspend fun getAllResponseClient(): List<UserData> {
        val response = api.getClient()
        ClientProvier.cliente = response
        return response
    }

    suspend fun getAllResponseOrder():List<Order> {
        val response =api.getOrder()
        OrderProvider.Order= response
        return response
    }

    suspend fun getAllResponseClientPost(formDataPost: UserDataPost) {
        val response = api.PostClient(formDataPost)
        return response
    }

    suspend fun getAllResponseDelivPost(formDataPost: bodyPost) {
        val response = api.PostDeliver(formDataPost)
        return response
    }

    suspend fun PostResponseOrder(formDataPost: OrderPost) {
        val response = api.PostOrder(formDataPost)
        return response
    }
}