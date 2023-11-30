package com.example.servigasv2.data.model.clienteModel

import com.squareup.moshi.Json

data class UserDataPost(
    @Json(name = "Auth")val AuthPost: AuthInfoPost,
    @Json(name = "FullName")val FullNamePost: String
)
data class AuthInfoPost(
    @Json(name = "Pass") val PassPost: String,
    @Json(name = "gmail")val emailclientPost: String
)


