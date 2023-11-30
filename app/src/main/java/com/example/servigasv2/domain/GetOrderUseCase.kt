package com.example.servigasv2.domain

import com.example.servigasv2.data.GlpRepository
import com.example.servigasv2.data.model.orderModel.Order

class GetOrderUseCase {
    private val repository = GlpRepository()

    suspend operator fun invoke(): List<Order>? = repository.getAllResponseOrder()
}