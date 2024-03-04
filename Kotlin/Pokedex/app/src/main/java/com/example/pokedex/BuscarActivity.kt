package com.example.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BuscarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar)

    val btnVerInformacionBuscar = findViewById<Button>(R.id.btn_verInformacionBuscar)
    val btnVolver = findViewById<Button>(R.id.btn_volverAtras_Buscar)

    btnVerInformacionBuscar.setOnClickListener{
        val intent = Intent(this,InfoPokemonActivity::class.java)
        startActivity(intent)
    }

    btnVolver.setOnClickListener{
        finish()
    }
    }
}