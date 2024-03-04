package com.example.verfuturo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Cogemos las referencias de la UI
        var btnEnviar: Button = findViewById<Button>(R.id.btnEnviar)
        val calendario: DatePicker = findViewById<DatePicker>(R.id.datePickerBirthdate)
        val txtNombre: EditText = findViewById(R.id.edTxtnombre)
        //Programamos el boton
        btnEnviar.setOnClickListener(){
            val nombre = txtNombre.text
            val dia = calendario.dayOfMonth
            val mes = calendario.month + 1 //Los meses empiezan en 0
            val anio = calendario.year

            //Mostramos la fecha escogida
            Toast.makeText(this,"Fecha seleccionada: $dia/$mes/$anio", Toast.LENGTH_SHORT).show()

            //Para realizar el envio de informacion de una Activity a la otra
            val intentFuturo = Intent(this,ActivityVerFuturo::class.java)
            //Añadir el nombre, dia y mes de nacimiento como extras al intent
            intentFuturo.putExtra("nombre",nombre.toString())
            intentFuturo.putExtra("dia",dia)
            intentFuturo.putExtra("mes",mes)
            startActivity(intentFuturo)
        }

    }
}