package com.example.servigasv2.PresentacioUI.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.servigasv2.databinding.InicioBinding

class MainActivity : AppCompatActivity() {

    private lateinit var  binding:InicioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = InicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ButtonIni.setOnClickListener(){
            val intent=Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.ButtonRe.setOnClickListener(){
            val intent=Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }







    }
}