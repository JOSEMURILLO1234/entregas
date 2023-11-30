package com.example.servigasv2.data.network

import com.example.servigasv2.core.RetrofitHelper
import com.example.servigasv2.data.model.clienteModel.UserData
import com.example.servigasv2.data.model.clienteModel.UserDataPost
import com.example.servigasv2.data.model.orderModel.Order
import com.example.servigasv2.data.model.orderModel.OrderPost
import com.example.servigasv2.model.body
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.servigasv2.data.model.repartidorModel.bodyPost


class GlpService {
    private val retrofit= RetrofitHelper.getRetrofit()


    suspend fun getDeliver(): List<body> {
        return try {
            withContext(Dispatchers.IO) {
                val response = retrofit.create(UserInterface::class.java).getAllDeliver()
                if (response.isSuccessful) {
                    response.body()?.contactInfoList ?: emptyList()
                }else{
                    emptyList()
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
            emptyList()
        }
    }
    suspend fun getClient(): List<UserData> {
        return try {
            withContext(Dispatchers.IO) {
                val response = retrofit.create(UserInterface::class.java).getAllClient()
                if(response.isSuccessful) {
                    response.body()?.body ?: emptyList()
                }else{
                    emptyList()
                }
            }
        }catch (e:Exception){
            e.printStackTrace()
            emptyList()
        }
    }

    suspend fun getOrder(): List<Order> {
        return try {
            withContext(Dispatchers.IO) {
                val response = retrofit.create(UserInterface::class.java).getAllOrder()
                if(response.isSuccessful) {
                    response.body()?.body ?: emptyList()
                }else{
                    emptyList()
                }
            }
        }catch (e:Exception){
            e.printStackTrace()
            emptyList()
        }
    }


    suspend fun PostClient(formData:UserDataPost) {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(UserInterface::class.java).postDatClient(formData)
            response.body()
        }
    }

    suspend fun PostDeliver(formData:bodyPost) {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(UserInterface::class.java).postDatDeliv(formData)
            response.body()
        }
    }

    suspend fun PostOrder(formData:OrderPost) {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(UserInterface::class.java).postDatOrder(formData)
            response.body()
        }
    }
}
