package com.example.servigasv2.PresentacioUI.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.servigasv2.data.model.clienteModel.UserData
import com.example.servigasv2.data.model.orderModel.Order
import com.example.servigasv2.domain.GetOrderUseCase
import kotlinx.coroutines.launch

class OrderViewModel: ViewModel() {

    val _orderModel = MutableLiveData<List<Order>?>()
    val orderModel: LiveData<List<Order>?> = _orderModel
    val isLoading = MutableLiveData<Boolean>()
    val getOrderUseCase= GetOrderUseCase()


    fun onCreate() {

        viewModelScope.launch {
            val result: List<Order>? = getOrderUseCase()
            _orderModel.postValue(result)
        }
    }

}