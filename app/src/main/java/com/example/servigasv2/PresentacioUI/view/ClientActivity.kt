package com.example.servigasv2.PresentacioUI.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.servigasv2.databinding.ActivityClientBinding
import com.example.servigasv2.domain.UserLoginAplication.Companion.prefs

class ClientActivity:AppCompatActivity() {
    private lateinit var  binding: ActivityClientBinding
    var cont=1
    var total = (0.000).toFloat()
    var totalm= (0.000).toFloat()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClientBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.UserC.text=prefs.getFullName()

        binding.imageViewBackC.setOnClickListener(){
            prefs.cleanData()
           startActivity(Intent(this,MainActivity::class.java))
        }

//check para  ingresar datos de  la ubicacion
        binding.CheckUbi.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                // Si el CheckBox está marcado
                // Realiza alguna acción
                binding.SwipeUbi.visibility=View.VISIBLE
                val layoutParams = binding.cardview.layoutParams as MarginLayoutParams
                layoutParams.setMargins(layoutParams.leftMargin, 1350, layoutParams.rightMargin, layoutParams.bottomMargin)
                binding.cardview.layoutParams = layoutParams
            } else {
                // Si el CheckBox está desmarcado
                // Realiza alguna otra acción
                binding.SwipeUbi.visibility=View.GONE
                val layoutParams = binding.cardview.layoutParams as MarginLayoutParams
                layoutParams.setMargins(layoutParams.leftMargin, 350, layoutParams.rightMargin, layoutParams.bottomMargin)
                binding.cardview.layoutParams = layoutParams
            }
        }
        operatorUnidades()
        binding.idSaveUbi.setOnClickListener(){

        }


    }
//OPERACION PARA DETERMINAR EL NUMERO DE UNIDADES  MAS EL PRECIO TOTAL
    fun operatorUnidades(){

        binding.contadorUP.setOnClickListener(){
            if(cont<=5) {
                cont += 1
                total = (cont* 2.70).toFloat()


            }
            binding.ViewUnidades.text=cont.toString()
            binding.ViewTotal.text= "$ $total 0"

        }
        binding.contadorDown.setOnClickListener(){
            if(cont>1) {
                cont -= 1
                totalm = (2.70 *(cont)).toFloat()
                total=totalm

            }
            binding.ViewUnidades.text=cont.toString()
            binding.ViewTotal.text= "$ $totalm 0"
        }
    }

    //VALIDAR CAMPOS DE LA UBICACION

    fun validateDatesUbi(){

        if(binding.idCallePrincipal.text.isNullOrEmpty() &&
            binding.idCalleSecun.text.isNullOrEmpty() &&
            binding.idReferencia.text.isNullOrEmpty()){

            Toast.makeText(this, "Completar la Informacion!!", Toast.LENGTH_SHORT).show()

        }else{

        }
    }


}

