package com.example.servigasv2.core

import android.util.Patterns
import com.example.servigasv2.databinding.LoginBinding
import com.example.servigasv2.databinding.RegisterBinding


object Validacion {

    fun validateEmailLogin(mBinding: LoginBinding):Boolean{
        var errorMessage: String?= null
        val value = mBinding.emailLogin.text.toString()
        if(value.isEmpty()){
            errorMessage ="Email es requerido"
        }else if(!Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            errorMessage ="El correo es invalido"
        }

        if(errorMessage != null){
            mBinding.emailLoginTill.apply {
                isErrorEnabled = true
                error=errorMessage
            }
        }
        return errorMessage == null
    }

    fun validatePass(mBinding: LoginBinding ):Boolean{
        var errorMessage:String?= null
        val value: String = mBinding.contraseALogin.text.toString()


        if (value.isEmpty()){
            errorMessage = "El campo es requerido"
        }

        if(errorMessage != null){
            mBinding.contraseALoginTill.apply {
                isErrorEnabled = true
                error=errorMessage
            }
        }
        return errorMessage == null
    }


     fun validateFullName(mBinding: RegisterBinding ):Boolean{
        var errorMessage:String?= null
        val value: String = mBinding.FullName.text.toString()


         if (value.isEmpty()){
            errorMessage = "El campo es requerido"
        }

        if(errorMessage != null){
            mBinding.FullNameTil.apply {
                isErrorEnabled = true
                error=errorMessage
            }
        }
        return errorMessage == null
    }
    fun validateEmail(mBinding: RegisterBinding):Boolean{
        var errorMessage: String?= null
        val value = mBinding.EmailReg.text.toString()
        if(value.isEmpty()){
            errorMessage ="Email es requerido"
        }else if(!Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            errorMessage ="El correo es invalido"
        }

        if(errorMessage != null){
            mBinding.EmailTil.apply {
                isErrorEnabled = true
                error=errorMessage
            }
        }
        return errorMessage == null
    }

     fun validatePassword(mBinding: RegisterBinding):Boolean{
        var errorMessage: String?= null
        val value = mBinding.PasswReg.text.toString()
        if(value.isEmpty()){
            errorMessage ="Contraseña es requerida"
        }else if(value.length <6){
            errorMessage ="contraseña menor de 6 caracteres"
        }
        if(errorMessage != null){
            mBinding.PasswrTil.apply {
                isErrorEnabled = true
                error=errorMessage
            }
        }

        return errorMessage == null

    }
     fun validateConfirmPasswr(mBinding: RegisterBinding):Boolean{
        var errorMessage: String?= null
        val value = mBinding.PasswRregConfirm.text.toString()
        if(value.isEmpty()){
            errorMessage ="Confirmar la contraseña"
        }else if(value.length <6){
            errorMessage ="contraseña menor de 6 caracteres"
        }
        if(errorMessage != null){
            mBinding.ConfirmPasswrTil.apply {
                isErrorEnabled = true
                error=errorMessage
            }
        }

        return errorMessage == null
    }

     fun validatePassandConfirmPass(mBinding: RegisterBinding):Boolean{
        var errorMessage: String?=null
        val Pass= mBinding.PasswReg.text.toString()
        val ConfirmPass= mBinding.PasswRregConfirm.text.toString()
        if(Pass != ConfirmPass){
            errorMessage = "Las contraseñas no coinciden"
        }
        if(errorMessage != null){
            mBinding.ConfirmPasswrTil.apply {
                isErrorEnabled = true
                error=errorMessage
            }
        }

        return errorMessage == null
    }

    fun valedateContact(mBinding: RegisterBinding):Boolean{
        var errorMessage: String?= null
        val value = mBinding.txtContacto.text.toString()
        if(value.isEmpty()){
            errorMessage ="Contacto es requerido"
        }else if((value.length > 10) || (value.length < 10)){
            errorMessage ="El contacto no es valido"
        }
        if(errorMessage != null){
            mBinding.contactoTil.apply {
                isErrorEnabled = true
                error=errorMessage
            }
        }
        return errorMessage == null
    }
    fun validateMarca(mBinding: RegisterBinding ):Boolean{
        var errorMessage:String?= null
        val value: String = mBinding.txtMarca.text.toString()


        if (value.isEmpty()){
            errorMessage = "El campo es requerido"
        }

        if(errorMessage != null){
            mBinding.marcaTil.apply {
                isErrorEnabled = true
                error=errorMessage
            }
        }
        return errorMessage == null
    }

    fun validatePlaca(mBinding: RegisterBinding ):Boolean{
        var errorMessage:String?= null
        val value: String = mBinding.txtPlaca.text.toString()


        if (value.isEmpty()){
            errorMessage = "El campo es requerido"
        }

        if(errorMessage != null){
            mBinding.placaTil.apply {
                isErrorEnabled = true
                error=errorMessage
            }
        }
        return errorMessage == null
    }


}