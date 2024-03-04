package com.example.uf1_multiplicadosnumeros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Obtener los contenidos del Activity
        val button: Button = findViewById(R.id.calculoButton)
        val operA: TextView = findViewById(R.id.txtOperandoA)
        val operB: TextView = findViewById(R.id.txtOperandoB)
        val res: TextView = findViewById(R.id.txtResultado)

        button.setOnClickListener(){
            val opA: Int = Integer.parseInt(operA.text.toString())
            val opB: Int = Integer.parseInt(operB.text.toString())
            val resultado: Int = opA*opB
            res.text = resultado.toString()
        }
    }
}