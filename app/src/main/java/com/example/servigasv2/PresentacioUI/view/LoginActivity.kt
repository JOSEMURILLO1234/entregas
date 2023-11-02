package com.example.servigasv2.PresentacioUI.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.servigasv2.databinding.DelivMainBinding
import com.example.servigasv2.databinding.LoginBinding

class LoginActivity:AppCompatActivity() {

    private lateinit var  binding: LoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back1.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

}