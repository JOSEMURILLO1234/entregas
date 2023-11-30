package com.example.servigasv2.data.model.clienteModel

import com.squareup.moshi.Json

data class clientModel(
   @Json(name = "body") val body: List<UserData>
)

data class UserData(
    @Json(name = "FullName")val FullName: String,
    @Json(name = "idUser")val idUser: String,
    @Json(name = "Auth")val Auth: AuthInfo
)

data class AuthInfo(
    @Json(name = "Pass") val Pass: String,
    @Json(name = "gmail")val emailclient: String
)

