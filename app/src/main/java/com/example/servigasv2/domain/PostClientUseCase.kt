package com.example.servigasv2.domain

import com.example.servigasv2.data.GlpRepository
import com.example.servigasv2.data.model.clienteModel.UserDataPost

class PostClientUseCase(private val fromDataPost: UserDataPost) {

    private val repository = GlpRepository()

    suspend operator fun invoke() = repository.getAllResponseClientPost(fromDataPost)

}