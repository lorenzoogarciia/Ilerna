package com.example.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LuchaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucha)

        val btnLuchar = findViewById<Button>(R.id.btn_luchar)
        val btnVolver = findViewById<Button>(R.id.btn_volverAtras_Lucha)

        btnLuchar.setOnClickListener {
            val intent = Intent(this,InfoLuchaActivity::class.java)
            startActivity(intent)
        }

        btnVolver.setOnClickListener{
            finish()
        }
    }
}