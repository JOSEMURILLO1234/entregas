package com.example.servigasv2.PresentacioUI.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.servigasv2.PresentacioUI.viewmodel.dViewModel
import com.example.servigasv2.databinding.DelivMainBinding
import com.example.servigasv2.domain.UserLoginAplication.Companion.prefs

class DelivActivity:AppCompatActivity() {

    private lateinit var  binding: DelivMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DelivMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.UserR.text=prefs.getFullNameD()

        binding.imageViewBackR.setOnClickListener(){
            prefs.cleanData()
            startActivity(Intent(this,MainActivity::class.java))
        }


    }

}