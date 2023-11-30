package com.example.servigasv2.PresentacioUI.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.servigasv2.PresentacioUI.viewmodel.ClientViewModel
import com.example.servigasv2.PresentacioUI.viewmodel.dViewModel
import com.example.servigasv2.R
import com.example.servigasv2.core.Validacion
import com.example.servigasv2.data.shared.Prefs
import com.example.servigasv2.databinding.LoginBinding
import com.example.servigasv2.domain.UserLoginAplication.Companion.prefs
import com.example.servigasv2.model.body
import java.io.IOException

class LoginActivity:AppCompatActivity() , View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener {

    private val ClientViewModel: ClientViewModel by viewModels()
    private val DelivViewModel: dViewModel by viewModels()
    private lateinit var  binding: LoginBinding
    private  var verify= Validacion
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
        binding = LoginBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        binding.emailLogin.onFocusChangeListener= this
        binding.contraseALogin.onFocusChangeListener= this
        ClientViewModel.onCreate()
        DelivViewModel.onCreate()
        
        binding.back1.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        ClientViewModel.clientModel.observe(this, Observer {resultClient ->

            if(!resultClient.isNullOrEmpty()) {

                binding.BotonLog.setOnClickListener(){
                    var boolc=true
                    val mail = binding.emailLogin.text.toString()
                    val pass = binding.contraseALogin.text.toString()


                        resultClient.forEach { userData ->

                            if (mail == userData.Auth.emailclient && pass == userData.Auth.Pass) {
                                prefs.saveId(userData.idUser) // almacena el  valor del ID del cliente
                                prefs.saveFull(userData.FullName)
                                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
                                if (binding.CheckDatos.isChecked){
                                    prefs.saveMail(mail) //almacena datos del mail del cliente
                                    prefs.savePass(pass) //almacena datos del mail del repartidor
                                }
                                boolc=false
                                val intent = Intent(this, ClientActivity::class.java)
                                startActivity(intent)
                            }
                        }

                    if(boolc){
                        Toast.makeText(this, "Usuario o Contraseña Invalidos", Toast.LENGTH_SHORT).show()
                        boolc=false
                    }

                    }
                }else{
                Toast.makeText(this, "Revise su conexión a internet", Toast.LENGTH_SHORT).show()
            }

        })

        DelivViewModel.delivModel.observe(this, Observer {resultDeliver ->

            if (!resultDeliver.isNullOrEmpty()) {

            binding.registerLogin.setOnClickListener(){
                var bool = true
                val mail = binding.emailLogin.text.toString()
                val pass = binding.contraseALogin.text.toString()

                    resultDeliver.forEach {
                        if (mail == it.authInfo.mail && pass == it.authInfo.pass) {
                            prefs.saveIdD(it.idDeliver)
                            prefs.saveFullD(it.fullNameD)
                            if (binding.CheckDatos.isChecked){
                                prefs.saveMailD(mail)
                                prefs.savePassD(pass)
                            }
                            bool=false
                            Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, DelivActivity::class.java)
                            startActivity(intent)
                        }
                    }
                    if(bool){
                        Toast.makeText(this, "Usuario o Contraseña Invalidos", Toast.LENGTH_SHORT).show()
                        bool=false
                    }
                }

            }else{
                Toast.makeText(this, "Revise su conexión a internet", Toast.LENGTH_SHORT).show()
            }

        })



    }
    //permite validar si el usario ya esta logueado
    fun initUI(){
        if(prefs.getMailD().isNotEmpty()) {
            startActivity(Intent(this,DelivActivity::class.java))
        }
        if(prefs.getMail().isNotEmpty()) {
            startActivity(Intent(this,ClientActivity::class.java))
        }
    }

//validaciones
    override fun onClick(view: View?) {
        TODO("Not yet implemented")
    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if(view != null) {

            when (view.id) {
                R.id.emailLogin -> {
                    if (hasFocus) {
                        if (binding.emailLoginTill.isErrorEnabled) {
                            binding.emailLoginTill.isErrorEnabled = false
                        }
                    } else {
                        verify.validateEmailLogin(binding)
                    }

                }
                R.id.contraseñaLogin -> {
                    if (hasFocus) {
                        if (binding.contraseALoginTill.isErrorEnabled) {
                            binding.contraseALoginTill.isErrorEnabled = false
                        }
                    } else {
                        verify.validatePass(binding)
                    }
                }
            }
        }
    }

    override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
        TODO("Not yet implemented")
    }

}