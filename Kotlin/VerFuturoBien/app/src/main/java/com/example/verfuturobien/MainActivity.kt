package com.example.verfuturobien

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Cogemos las referencias de la UI
        var btnEnviar: Button = findViewById<Button>(R.id.btnEnviar)
        val calendario: DatePicker = findViewById<DatePicker>(R.id.datePickerBirthdate)
        //Programamos el boton
        btnEnviar.setOnClickListener(){
            val dia = calendario.dayOfMonth
            val mes = calendario.month + 1 //Los meses empiezan en 0
            val anio = calendario.year
            //Mostramos la fecha escogida
            Toast.makeText(this,"Fecha seleccionada: $dia/$mes/$anio", Toast.LENGTH_SHORT).show()
        }
    }
}