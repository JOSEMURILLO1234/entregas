package com.example.servigasv2.domain

import com.example.servigasv2.data.GlpRepository
import com.example.servigasv2.data.model.clienteModel.UserData
import com.example.servigasv2.data.model.clienteModel.UserDataPost
import com.example.servigasv2.model.body

class GetClientUseCase {
    private val repository = GlpRepository()

    suspend operator fun invoke(): List<UserData>? {
       return repository.getAllResponseClient()
    }

}