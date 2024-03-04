package com.example.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class InfoPokedexActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_pokedex)

        val btnAtras = findViewById<ImageButton>(R.id.btn_atras_info)

        btnAtras.setOnClickListener {
            finish()
        }

    }
}