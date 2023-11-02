package com.example.servigasv2.PresentacioUI.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.servigasv2.PresentacioUI.viewmodel.dViewModel
import com.example.servigasv2.databinding.DelivMainBinding

class DelivActivity:AppCompatActivity() {

    private lateinit var  binding: DelivMainBinding
    private val deliverViewModel: dViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DelivMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        deliverViewModel.onCreate()

        deliverViewModel.deliverModel.observe(this, Observer {resultDeliver ->

        })


    }

}