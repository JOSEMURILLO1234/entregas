package com.example.servigasv2.PresentacioUI.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.servigasv2.model.deliverModel
import com.example.servigasv2.domain.GetDeliverUseCase
import com.example.servigasv2.model.body
import kotlinx.coroutines.launch
import retrofit2.Call

class dViewModel: ViewModel() {

    val deliverModel =MutableLiveData<body>()
    val getDeliverUseCase=GetDeliverUseCase()

    fun onCreate() {

        viewModelScope.launch {
          val result: List<body>? = getDeliverUseCase()

            if(!result.isNullOrEmpty()){
                deliverModel.postValue(result[0])
            }

        }
    }

}

