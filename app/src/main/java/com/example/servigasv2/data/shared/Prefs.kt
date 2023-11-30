package com.example.servigasv2.data.shared

import android.content.Context

class Prefs(val context:Context) {

    val SHARED_NAME="MyDates"
    val SHARED_FULLNAME="fullName"
    val SHARED_MAIL_CLIENT="mailClient"
    val SHARED_PASS_CLIENT="passClient"
    val SHARED_ID_CLIENT="IdClient"
    val SHARED_NAME_D="MyDatesD"
    val SHARED_FULLNAMED="fullNameD"
    val SHARED_MAIL_DELIV="mailClient"
    val SHARED_PASS_DELIV="passClient"
    val SHARED_ID_DELIV="IdClient"

    //CLIENT
    val storege= context.getSharedPreferences(SHARED_NAME, 0)
    val storeged= context.getSharedPreferences(SHARED_NAME_D, 0)

    fun saveFull(fullname:String){
        storege.edit().putString(SHARED_FULLNAME,fullname).apply()
    }
    fun saveMail(mail:String){
        storege.edit().putString(SHARED_MAIL_CLIENT,mail).apply()
    }

    fun savePass(Pass:String){
        storege.edit().putString(SHARED_PASS_CLIENT,Pass).apply()
    }
    fun saveId(Id:String){
        storege.edit().putString(SHARED_ID_CLIENT,Id).apply()
    }

    fun getMail():String{
        return storege.getString(SHARED_MAIL_CLIENT,"")!!
    }
    fun getPass():String{
        return storege.getString(SHARED_PASS_CLIENT,"")!!
    }
    fun getId():String{
        return storege.getString(SHARED_ID_CLIENT,"")!!
    }
    fun getFullName():String{
        return storege.getString(SHARED_FULLNAME,"")!!
    }
    fun cleanData(){
        storeged.edit().clear().apply()
        storege.edit().clear().apply()
    }

    //DELIVER

    fun saveFullD(fullnamed:String){
        storeged.edit().putString(SHARED_FULLNAMED,fullnamed).apply()
    }

    fun saveMailD(maild:String){
        storeged.edit().putString(SHARED_MAIL_DELIV,maild).apply()
    }

    fun savePassD(Passd:String){
        storeged.edit().putString(SHARED_PASS_DELIV,Passd).apply()
    }
    fun saveIdD(IdD:String){
        storeged.edit().putString(SHARED_ID_DELIV,IdD).apply()
    }
    fun getFullNameD():String{
        return storeged.getString(SHARED_FULLNAMED,"")!!
    }

    fun getMailD():String{
        return storeged.getString(SHARED_MAIL_DELIV,"")!!
    }
    fun getPassD():String{
        return storeged.getString(SHARED_PASS_DELIV,"")!!
    }
    fun getIdD():String{
        return storeged.getString(SHARED_ID_DELIV,"")!!
    }

}