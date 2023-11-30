package com.example.servigasv2.PresentacioUI.view
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.example.servigasv2.PresentacioUI.viewmodel.ClientViewModel
import com.example.servigasv2.PresentacioUI.viewmodel.ClientViewModelPost
import com.example.servigasv2.PresentacioUI.viewmodel.dViewModel
import com.example.servigasv2.PresentacioUI.viewmodel.dViewModelPost
import com.example.servigasv2.R
import com.example.servigasv2.core.Validacion
import com.example.servigasv2.data.model.clienteModel.AuthInfoPost
import com.example.servigasv2.data.model.clienteModel.UserDataPost
import com.example.servigasv2.data.model.repartidorModel.AuthInfo
import com.example.servigasv2.data.model.repartidorModel.VehicleInfo
import com.example.servigasv2.data.model.repartidorModel.bodyPost
import com.example.servigasv2.databinding.RegisterBinding


class RegisterActivity:AppCompatActivity(), View.OnClickListener,View.OnFocusChangeListener, View.OnKeyListener {
    private lateinit var  binding: RegisterBinding
    private  var verify= Validacion
    private val ClientViewModel: ClientViewModel by viewModels()
    private val DeliverViewModel: dViewModel by viewModels()
    private val ClientViewModelPost: ClientViewModelPost by viewModels()
    private val DeliverViewModelPost: dViewModelPost by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        ClientViewModel.onCreate()
        binding.FullName.onFocusChangeListener= this
        binding.EmailReg.onFocusChangeListener= this
        binding.PasswReg.onFocusChangeListener= this
        binding.PasswRregConfirm.onFocusChangeListener= this
        binding.txtContacto.onFocusChangeListener= this
        binding.txtMarca.onFocusChangeListener= this
        binding.txtPlaca.onFocusChangeListener= this
        DeliverViewModel.onCreate()

        binding.back2.setOnClickListener(){

            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

                //permite escoger si es cliente o repartidor

        binding.clientRegister.setOnClickListener(){

            binding.registerDriver.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
            binding.clientRegister.setBackgroundColor(ContextCompat.getColor(this,R.color.user))
            binding.txtdatsCar.visibility = View.GONE
            binding.txtContacto.visibility = View.GONE
            binding.FullName.visibility=View.VISIBLE
            binding.EmailReg.visibility=View.VISIBLE
            binding.PasswReg.visibility=View.VISIBLE
            binding.PasswRregConfirm.visibility=View.VISIBLE
            binding.PasswrTil.visibility=View.VISIBLE
            binding.ConfirmPasswrTil.visibility=View.VISIBLE
            binding.txtContacto.text?.clear()
            binding.txtMarca.visibility = View.GONE
            binding.txtMarca.text?.clear()
            binding.txtPlaca.visibility = View.GONE
            binding.txtPlaca.text?.clear()
            binding.placaTil.isErrorEnabled = false
            binding.marcaTil.isErrorEnabled = false
            binding.contactoTil.isErrorEnabled = false


            binding.registerButton.setOnClickListener(){

                if (!binding.FullNameTil.isErrorEnabled && !binding.FullName.text.isNullOrEmpty()
                    && !binding.EmailReg.text.isNullOrEmpty() && !binding.EmailTil.isErrorEnabled
                    && !binding.FullName.text.isNullOrEmpty() && !binding.FullNameTil.isErrorEnabled
                    && !binding.PasswReg.text.isNullOrEmpty() && !binding.PasswrTil.isErrorEnabled
                    && !binding.PasswRregConfirm.text.isNullOrEmpty() && !binding.ConfirmPasswrTil.isErrorEnabled
                ) {
                    val FullName = binding.FullName.text.toString()
                    val Email = binding.EmailReg.text.toString()
                    val pass = binding.PasswRregConfirm.text.toString()
                    val requestBody = UserDataPost(
                        AuthPost = AuthInfoPost(
                            PassPost = pass,
                            emailclientPost = Email
                        ) ,
                        FullNamePost = FullName
                    )

                    ClientViewModel.clientModel.observe(this, Observer { resultClient ->
                        var emailverifi= false
                        resultClient?.forEach {

                            if (Email == it.Auth.emailclient) {
                                val mail = it.Auth.emailclient
                                Toast.makeText(
                                    this,
                                    "$mail ya Existe",
                                    Toast.LENGTH_SHORT
                                ).show()
                                emailverifi=true
                            }
                        }

                        if (!emailverifi){
                            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
                            ClientViewModelPost.enviardatos(requestBody)
                            val intentClient = Intent(this,MainActivity::class.java)
                            startActivity(intentClient)
                        }
                    })

                } else {
                    Toast.makeText(this, "Es necesario llenar los campos", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
//permite escojer registrar como Repartidor
        binding.registerDriver.setOnClickListener(){

            binding.registerDriver.setBackgroundColor(ContextCompat.getColor(this,R.color.user))
            binding.clientRegister.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
            binding.FullName.visibility=View.VISIBLE
            binding.EmailReg.visibility=View.VISIBLE
            binding.PasswReg.visibility=View.VISIBLE
            binding.PasswRregConfirm.visibility=View.VISIBLE
            binding.PasswrTil.visibility=View.VISIBLE
            binding.ConfirmPasswrTil.visibility=View.VISIBLE
            binding.txtdatsCar.visibility = View.VISIBLE
            binding.txtContacto.visibility = View.VISIBLE
            binding.txtMarca.visibility = View.VISIBLE
            binding.txtPlaca.visibility = View.VISIBLE
// pulsar boton de registro  valida si los campos sean correctamente llenados
            binding.registerButton.setOnClickListener(){

                if ((!binding.FullNameTil.isErrorEnabled && !binding.FullName.text.isNullOrEmpty())
                    && (!binding.EmailReg.text.isNullOrEmpty() && !binding.EmailTil.isErrorEnabled)
                    && (!binding.FullName.text.isNullOrEmpty() && !binding.FullNameTil.isErrorEnabled)
                    && !binding.PasswReg.text.isNullOrEmpty() && !binding.PasswrTil.isErrorEnabled
                    && !binding.PasswRregConfirm.text.isNullOrEmpty() && !binding.ConfirmPasswrTil.isErrorEnabled
                    && !binding.txtContacto.text.isNullOrEmpty() && !binding.contactoTil.isErrorEnabled
                    && !binding.txtMarca.text.isNullOrEmpty() && !binding.marcaTil.isErrorEnabled
                    && !binding.txtPlaca.text.isNullOrEmpty() && !binding.placaTil.isErrorEnabled
                ) {

                    val contact = binding.txtContacto.text.toString()
                    val FullName = binding.FullName.text.toString()
                    val Email = binding.EmailReg.text.toString()
                    val pass = binding.PasswRregConfirm.text.toString()
                    val marca = binding.txtMarca.text.toString()
                    val placa = binding.txtPlaca.text.toString()

//objeto que permite encapsular los datos del repartidor y enviarlos al Post en la Base de datos
                    val requestBodyDeliv = bodyPost(
                        contacto = contact,
                        fullNameD = FullName,
                        vehicleInfo = VehicleInfo(
                            marca = marca,
                            placa = placa,
                        ),
                        authInfo = AuthInfo(
                            pass = pass,
                            mail = Email
                        )
                    )
                    //validacion del repartidor si ya existe en la base de datos y enivio de la informacion del formulario en caso de que aun no

                    DeliverViewModel.delivModel.observe(this, Observer { Repartidor ->
                        var emailDelivVerif=false
                        Repartidor?.forEach {
                            if (Email==it.authInfo.mail){
                                val mail = it.authInfo.mail
                                Toast.makeText(
                                    this,
                                    "$mail ya Existe",
                                    Toast.LENGTH_SHORT
                                ).show()
                                emailDelivVerif=true
                            }
                        }

                        if(!emailDelivVerif){
                            DeliverViewModelPost.enviardatosDeliv(requestBodyDeliv)
                            val intentClient = Intent(this,MainActivity::class.java)
                            startActivity(intentClient)
                        }
                    })



                } else {
                    Toast.makeText(this, "Es necesario llenar los campos", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

    }

    //permite la validacion de cada  campo del formulario

    override fun onClick(view: View?) {

    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {

        if(view != null){

            when(view.id){
                R.id.FullName -> {
                    if(hasFocus){
                        if(binding.FullNameTil.isErrorEnabled){
                            binding.FullNameTil.isErrorEnabled=false
                        }
                    }else{
                        verify.validateFullName(binding)
                    }

                }

                R.id.EmailReg -> {

                    if(hasFocus){
                        if(binding.EmailTil.isErrorEnabled){
                            binding.EmailTil.isErrorEnabled=false
                        }
                    }else{
                        verify.validateEmail(binding)
                    }

                }

                R.id.PasswReg -> {
                    if(hasFocus){
                        if(binding.PasswrTil.isErrorEnabled){
                            binding.PasswrTil.isErrorEnabled=false
                        }
                    }else{
                        verify.validatePassword(binding)
                    }
                }
                R.id.PasswRregConfirm -> {
                    if(hasFocus){
                        if(binding.ConfirmPasswrTil.isErrorEnabled){
                            binding.ConfirmPasswrTil.isErrorEnabled=false
                        }
                    }else{
                        verify.validateConfirmPasswr(binding)
                        verify.validatePassandConfirmPass(binding)
                    }
                }
                R.id.txtContacto -> {
                    if (hasFocus){
                        if (binding.contactoTil.isErrorEnabled){
                            binding.contactoTil.isErrorEnabled=false
                        }
                    }else{
                        verify.valedateContact(binding)
                    }
                }

                R.id.txtMarca -> {
                    if (hasFocus){
                        if (binding.marcaTil.isErrorEnabled){
                            binding.marcaTil.isErrorEnabled=false
                        }
                    }else{
                        verify.validateMarca(binding)
                    }
                }
                R.id.txtPlaca -> {
                    if (hasFocus){
                        if (binding.placaTil.isErrorEnabled){
                            binding.placaTil.isErrorEnabled=false
                        }
                    }else{
                        verify.validatePlaca(binding)
                    }
                }

            }

        }
    }

    override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
        TODO("Not yet implemented")
    }
}
