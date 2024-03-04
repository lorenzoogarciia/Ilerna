package com.example.pokedex

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_main)

        // Asignamos los botones por ID
        val btnPokedex = findViewById<Button>(R.id.btn_pokedex)
        val btnBuscarPokemon = findViewById<Button>(R.id.btn_buscar_pokemon)
        val btnCombatePokemon = findViewById<Button>(R.id.btn_combate_pokemon)

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