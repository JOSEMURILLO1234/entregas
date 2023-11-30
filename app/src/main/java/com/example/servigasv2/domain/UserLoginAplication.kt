package com.example.servigasv2.domain

import android.app.Application
import com.example.servigasv2.data.shared.Prefs
// permite hacer  llamadas y  requerimiento de informacion desde el Prefs
class UserLoginAplication:Application() {
companion object{
    lateinit var prefs: Prefs
}
    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}