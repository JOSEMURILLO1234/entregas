package com.example.servigasv2.PresentacioUI.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.servigasv2.data.model.orderModel.OrderPost
import com.example.servigasv2.domain.PostOrderUseCse
import kotlinx.coroutines.launch

class OrderViewModelPost: ViewModel() {

    fun enviardatosOeder(formDataOrder: OrderPost){

        viewModelScope.launch {
            val postOrderUc= PostOrderUseCse(formDataOrder)
            postOrderUc()
        }
    }

}