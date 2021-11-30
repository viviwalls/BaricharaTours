package com.christianrruiz.proyecto

import com.google.gson.annotations.SerializedName

data class SitiosItem(
    @SerializedName("calificacion")
    val calificacion: String,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("urlFoto")
    val urlFoto: String
)