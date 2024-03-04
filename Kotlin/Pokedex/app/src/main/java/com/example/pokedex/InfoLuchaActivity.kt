package com.example.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InfoLuchaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_lucha)

    val btnVolver = findViewById<Button>(R.id.btn_volverAtras_Lucha)

    btnVolver.setOnClickListener{
        finish()
    }
    }
}