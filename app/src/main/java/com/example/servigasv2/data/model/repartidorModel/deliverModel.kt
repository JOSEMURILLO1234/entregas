package com.example.servigasv2.model
import com.squareup.moshi.Json

data class deliverModel(
    @Json(name = "body")
    val contactInfoList:List<body>
)

data class body(
    @Json(name = "idDeliver") val idDeliver: String,
    @Json(name = "contacto") val contacto: String,
    @Json(name = "FullNameD") val fullNameD: String,
    @Json(name = "Auth") val authInfo: AuthInfo,
    @Json(name = "Vehiculo") val vehicleInfo: VehicleInfo
)



data class VehicleInfo(
    @Json(name = "Marca") val marca: String,
    @Json(name = "Placa") val placa: String
)

data class AuthInfo(
    @Json(name = "Pass") val pass: String,
    @Json(name = "mail") val mail: String
)
