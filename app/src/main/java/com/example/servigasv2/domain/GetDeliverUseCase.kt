package com.example.servigasv2.domain

import com.example.servigasv2.data.GlpRepository
import com.example.servigasv2.model.body
import com.example.servigasv2.model.deliverModel
import retrofit2.Call

class GetDeliverUseCase {
    private val repository =GlpRepository()

    suspend operator fun invoke(): List<body>? = repository.getAllResponse()

}

