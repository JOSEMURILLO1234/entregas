package com.example.servigasv2.domain

import com.example.servigasv2.data.GlpRepository
import com.example.servigasv2.data.model.repartidorModel.bodyPost

class PostDeliverUseCase(private val fromDataPost: bodyPost) {

    private val repository = GlpRepository()

    suspend operator fun invoke() = repository.getAllResponseDelivPost(fromDataPost)

}