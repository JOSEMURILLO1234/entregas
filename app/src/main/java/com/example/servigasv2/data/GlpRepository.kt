package com.example.servigasv2.data

import com.example.servigasv2.DeliverProvider
import com.example.servigasv2.data.network.GlpService
import com.example.servigasv2.model.body
import com.example.servigasv2.model.deliverModel
import retrofit2.Call

class GlpRepository {
    private val api=GlpService()

    suspend fun getAllResponse():List<body>{
        val response = api.getDeliver()
        DeliverProvider.deliver= response
        return response
    }
}