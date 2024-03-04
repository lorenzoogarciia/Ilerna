package com.example.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PokedexActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokedex)

        val btnVerInformacion = findViewById<Button>(R.id.btn_verInformacion)
        val btnVolver = findViewById<Button>(R.id.btn_volverAtras_Pokedex)

        btnVerInformacion.setOnClickListener {
            val intent = Intent(this, InfoPokedexActivity::class.java)
            startActivity(intent)
        }

        btnVolver.setOnClickListener {
            finish()
        }
    }
    }
