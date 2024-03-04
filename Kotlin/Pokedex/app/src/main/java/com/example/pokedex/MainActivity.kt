package com.example.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Asignamos los botones por ID
        val btnPokedex = findViewById<Button>(R.id.btn_pokedex)
        val btnBuscarPokemon = findViewById<Button>(R.id.btn_buscar)
        val btnCombatePokemon = findViewById<Button>(R.id.btn_lucha)

        btnPokedex.setOnClickListener {
            val intent = Intent(this, PokedexActivity::class.java)
            startActivity(intent)
        }

        btnBuscarPokemon.setOnClickListener {
            val intent = Intent(this, BuscarActivity::class.java)
            startActivity(intent)
        }

        btnCombatePokemon.setOnClickListener {
            val intent = Intent(this, LuchaActivity::class.java)
            startActivity(intent)
        }
    }
}

