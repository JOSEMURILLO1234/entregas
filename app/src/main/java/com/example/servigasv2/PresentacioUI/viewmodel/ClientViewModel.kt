package com.example.servigasv2.PresentacioUI.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.servigasv2.data.GlpRepository
import com.example.servigasv2.data.model.clienteModel.UserData
import com.example.servigasv2.data.model.clienteModel.clientModel
import com.example.servigasv2.domain.GetClientUseCase
import kotlinx.coroutines.launch


class ClientViewModel:ViewModel() {


    val _clientModel = MutableLiveData<List<UserData>?>()
    val clientModel: LiveData<List<UserData>?> = _clientModel
    val isLoading = MutableLiveData<Boolean>()
    val getClientUseCase= GetClientUseCase()


    fun onCreate() {

        viewModelScope.launch {
            val result: List<UserData>? = getClientUseCase()
            _clientModel.postValue(result)
        }
    }
}


