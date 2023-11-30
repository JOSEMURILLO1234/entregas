package com.example.servigasv2.data.model.orderModel

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class OrderModel(
    @Json(name = "body") val body: List<Order>
)

@JsonClass(generateAdapter = true)
data class Order(
    @Json(name = "idOrder") val idOrder: String,
    @Json(name = "contactDriver") val contactDriver: String,
    @Json(name = "DriverName") val driverName: String,
    @Json(name = "Glp") val glp: Int,
    @Json(name = "Gdeliver") val gdeliver: Location,
    @Json(name = "Direccion") val direccion: String,
    @Json(name = "ClientName") val clientName: String,
    @Json(name = "PlateDriver") val plateDriver: String,
    @Json(name = "Gclient") val gclient: Location
)

@JsonClass(generateAdapter = true)
data class Location(
    @Json(name = "lat") val lat: Double,
    @Json(name = "lon") val lon: Double
)
