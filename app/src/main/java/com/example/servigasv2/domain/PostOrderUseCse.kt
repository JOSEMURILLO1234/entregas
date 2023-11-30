package com.example.servigasv2.domain

import com.example.servigasv2.data.GlpRepository
import com.example.servigasv2.data.model.orderModel.OrderPost

class PostOrderUseCse( private val formDataOrderPost: OrderPost  ) {

    private val repository = GlpRepository()

    suspend operator fun invoke() = repository.PostResponseOrder(formDataOrderPost)

}