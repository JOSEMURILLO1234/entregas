package com.example.servigasv2.PresentacioUI.view

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.servigasv2.R
import com.example.servigasv2.core.Validacion
import com.example.servigasv2.databinding.RegisterBinding

class RegisterActivity:AppCompatActivity(), View.OnClickListener,View.OnFocusChangeListener, View.OnKeyListener {
    private lateinit var  binding: RegisterBinding
    private  var verify= Validacion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = RegisterBinding.inflate(layoutInflater)
        binding = RegisterBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.FullName.onFocusChangeListener= this
        binding.EmailReg.onFocusChangeListener= this
        binding.PasswReg.onFocusChangeListener= this
        binding.PasswRregConfirm.onFocusChangeListener= this
        binding.txtContacto.onFocusChangeListener= this
        binding.txtMarca.onFocusChangeListener= this
        binding.txtPlaca.onFocusChangeListener= this

        binding.back2.setOnClickListener(){

            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //permite escoger si es cliente o repartidor
        binding.SwCR.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked){
                binding.SwCR.text="Repartidor"
                binding.txtdatsCar.visibility = View.VISIBLE
                binding.txtContacto.visibility = View.VISIBLE
                binding.txtMarca.visibility= View.VISIBLE
                binding.txtPlaca.visibility= View.VISIBLE


            }else{
                binding.SwCR.text="Cliente"
                binding.txtdatsCar.visibility = View.GONE
                binding.txtContacto .visibility = View.GONE
                binding.txtContacto.text?.clear()
                binding.txtMarca.visibility= View.GONE
                binding.txtMarca.text?.clear()
                binding.txtPlaca.visibility= View.GONE
                binding.txtPlaca.text?.clear()
                binding.placaTil.isErrorEnabled=false
                binding.marcaTil.isErrorEnabled=false
                binding.contactoTil.isErrorEnabled=false

            }


        }


    }

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