package com.example.sharedpreferences

import android.content.Context

class Preferencias (contexto: Context) {
    val PREF_NOMBRE = "MisDatos" //Datos
    val PREF_USUARIO = "nombre"  //Valor 1
    val PREF_COLOR = "color" //Valor 2

    val pref = contexto.getSharedPreferences(PREF_NOMBRE, Context.MODE_PRIVATE)

    fun guardarDatos(nombre: String, color: String) {
        pref.edit().putString(PREF_USUARIO, nombre).apply()
        pref.edit().putString(PREF_COLOR, color).apply()
    }

    fun borrarDatos() {
        pref.edit().remove(PREF_USUARIO).apply()
    }

    fun getNombre(): String {
        return pref.getString(PREF_USUARIO, "ESTA VACIO")!!
    }

    fun getColor(): String {
        return pref.getString(PREF_COLOR, "black")!!
    }
}