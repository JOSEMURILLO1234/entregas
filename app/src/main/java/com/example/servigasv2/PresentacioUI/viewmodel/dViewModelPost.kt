package com.example.servigasv2.PresentacioUI.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.servigasv2.core.RetrofitHelper
import com.example.servigasv2.data.model.repartidorModel.bodyPost
import com.example.servigasv2.data.network.UserInterface
import com.example.servigasv2.domain.PostClientUseCase
import com.example.servigasv2.domain.PostDeliverUseCase
import kotlinx.coroutines.launch

class dViewModelPost:ViewModel() {

    fun enviardatosDeliv(formDataDeliver: bodyPost){

            viewModelScope.launch {
                val postdeliverUc= PostDeliverUseCase(formDataDeliver)
                postdeliverUc()
            }
    }
}