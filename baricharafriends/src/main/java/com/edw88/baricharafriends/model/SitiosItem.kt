package com.edw88.baricharafriends.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SitiosItem(
    @SerializedName("calificacion")
    val calificacion: String,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("urlFoto")
    val urlFoto: String,
    @SerializedName("descripcionLarga")
    val descripcionlarga : String,

) : Serializable