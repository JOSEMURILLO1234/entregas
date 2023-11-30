package com.example.servigasv2.PresentacioUI.viewmodel

import android.util.Log
import android.util.Log.d
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.servigasv2.core.RetrofitHelper
import com.example.servigasv2.data.GlpRepository
import com.example.servigasv2.data.model.clienteModel.AuthInfo
import com.example.servigasv2.data.model.clienteModel.UserData
import com.example.servigasv2.data.model.clienteModel.UserDataPost
import com.example.servigasv2.data.model.clienteModel.clientModel
import com.example.servigasv2.data.network.GlpService
import com.example.servigasv2.data.network.UserInterface
import com.example.servigasv2.domain.PostClientUseCase
import com.example.servigasv2.domain.PostDeliverUseCase
import com.github.ajalt.timberkt.d
import kotlinx.coroutines.launch
import retrofit2.Response

class ClientViewModelPost:ViewModel(){

    fun enviardatos(formData: UserDataPost){

       viewModelScope.launch {
           val PostClient= PostClientUseCase(formData)
           PostClient()
       }
    }
}