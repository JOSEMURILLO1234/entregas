package com.example.servigasv2.PresentacioUI.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.servigasv2.data.GlpRepository
import com.example.servigasv2.data.model.clienteModel.UserData
import com.example.servigasv2.data.model.clienteModel.clientModel
import com.example.servigasv2.domain.GetDeliverUseCase
import com.example.servigasv2.model.body
import kotlinx.coroutines.launch

class dViewModel: ViewModel() {

    val _deliverModel =MutableLiveData<List<body>?>()
    val isLoading = MutableLiveData<Boolean>()
    val delivModel: LiveData<List<body>?> = _deliverModel
    val getDeliverUseCase=GetDeliverUseCase()


    fun onCreate() {

        viewModelScope.launch {
          val result: List<body>? = getDeliverUseCase()
            if(!result.isNullOrEmpty()){
                _deliverModel.postValue(result)
            }

        }


    }



}

