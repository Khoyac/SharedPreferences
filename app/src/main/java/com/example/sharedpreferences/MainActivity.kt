package com.example.sharedpreferences

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.sharedpreferences.databinding.ActivityMainBinding
import com.example.sharedpreferences.primeraPagina.Companion.pref

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val colores = mapOf<String, Int>(
        "black" to Color.BLACK,
        "red" to Color.RED,
        "blue" to Color.BLUE,
        "verde" to Color.GREEN
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = Preferencias(applicationContext)

        binding.btGuardar.setOnClickListener {
            guardarDatos()
        }

        binding.btMostrar.setOnClickListener {
            mostrarValor(pref.getNombre())
            colores[pref.getColor()]?.let { it1 -> binding.etColor.setBackgroundColor(it1) }
        }

        binding.btBorrar.setOnClickListener {
            borrarDatos()
            mostrarValor(null.toString())
        }
    }

    private fun borrarDatos() {
        pref.borrarDatos()
    }

    private fun guardarDatos() {
        if (binding.etNombre.text.toString().isNotEmpty()) {
            pref.guardarDatos(binding.etNombre.text.toString(), binding.etColor.text.toString())
        }
    }

    private fun mostrarValor(message: String) {
        val alerta = AlertDialog.Builder(this)
        alerta.setTitle(pref.PREF_NOMBRE)
        alerta.setMessage(message)
        val dialogo = alerta.create()
        dialogo.show()
    }
}