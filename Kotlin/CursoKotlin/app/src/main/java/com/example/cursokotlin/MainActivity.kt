package com.example.cursokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
val TAG = ":::TAG"
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        variablesYConstants()
        tiposDeDatos()
        */
        //operadores()
        //nullSafety()
        //funciones()
        //clases()
        //botDeSeguridad()
        dogHello()


    }

    // Aquí vamos a ver variables y constantes
    /*private fun variablesYConstants() {
        /*
        * 1.-Nombre para representar el valor de un dato
        * */
        var name = "Hello world!"
        val constant = "Adios mundo!"
        Log.d(TAG, constant)
    }

    private fun tiposDeDatos() {
        //Cadenas de texto
        var string = "Lorenzo"
        // Valores enteros (int, short, long, byte)
        var number: Long = 10
        number = 7
        //Valores decimales (double, float)
        var decim = 3.4
        //Booleanos
        var boolean = true
        var boolean2 = false

        Log.d(TAG, number.toString())
    }

    private fun operadores() {
        val firstValue = 5
        val secondValue = 3

        //Operadores aritmeticos
        val suma = firstValue + secondValue
        Log.d(TAG, "Suma: $suma")
        val resta = firstValue - secondValue
        Log.d(TAG, "Resta: $resta")
        val mult = firstValue * secondValue
        Log.d(TAG, "Multiplicacion: $mult")
        val div = firstValue / secondValue
        Log.d(TAG, "Division: $div")

        //Operadores de comparacion
        val igualdad = firstValue == secondValue
        val desigualdad = firstValue != secondValue
        val menor = firstValue < secondValue
        val mayor = firstValue > secondValue
        val menorIgual = firstValue <= secondValue
        val mayorIgual = firstValue >= secondValue
        Log.d(TAG, "El resultado es: $mayor")

        //Operadores logicos
        val name = "Lorenzo"
        val num = 51
        val menor2 = num < 50
        val igualdad2 = name == "Lorenzo"
        val conjuncion = igualdad2 && menor2
        val disyuncion = igualdad2 || menor2
        val negacion = !igualdad2

        Log.d(TAG, "El resultado es: $negacion")
    }

    private fun nullSafety() {
        val nullString: String? = null


        if (nullString != null) {
            Log.d(TAG, "El resultado es: $nullString")
        }

        nullString?.let {
            Log.d(TAG, nullString)
        } ?: run {
            Log.d(TAG, nullString!!)
        }
    }

    private fun funciones() {
        printName("Lorenzo")
        val calculaEdad = funcionRetorno(2003)
        Log.d(TAG, "Mi edad es: $calculaEdad")
    }

    private fun printName(nombre: String) {
        Log.d(TAG, "Mi nombre es $nombre")
    }

    private fun funcionRetorno(birthYear: Int): Int = 2023 - birthYear

    private fun clases() {
        val LorenzoData=PersonData("Lorenzo",20)
        val PalomaData = PersonData("Paloma",21)
        val Lorenzo = Persona(LorenzoData)
        val Paloma = Persona(PalomaData)

        Paloma.presentacion()
        Lorenzo.presentacion()
    }

    class Persona(private val data: PersonData) {
        fun presentacion(){
            Log.d(TAG, "Mi nombre es ${data.name} y tengo ${data.age} años")
        }
    }

    data class PersonData (
            val name: String?,
            val age: Int
            )*/


    private fun botDeSeguridad(){
        val persona = Persona("Lorenzo",23, arrayListOf("Programar","Gimnasio","Futbol"))

        if(persona.name == "Lorenzo"){
            Log.d(TAG, "Bienvenido ${persona.name}")

            when(persona.age){
                in 0..17 -> {
                    Log.d(TAG, "Tienes ${persona.age} años, eres demasiado joven para acceder.")
                }
                in 18..64 -> {
                    Log.d(TAG, "Tienes ${persona.age} años, eres mayor de edad, bienvenido.")

                    for(hobby: String in persona.hobbies){
                        Log.d(TAG, "Te gusta $hobby")
                    }
                }
                in 65..100 -> {
                    Log.d(TAG, "Tienes ${persona.age} años, eres demasiado mayor para acceder.")
                }
            }
        }else{
            Log.d(TAG,"Largo de aqui ${persona.name}")
        }

    }

    data class Persona(
        val name: String,
        val age: Int,
        val hobbies: ArrayList<String>
    )

    open class Dog{
        open fun sayHello(){
            Log.d(TAG,"guau guau")
        }
    }

    class Yorkshire: Dog() {
        override fun  sayHello(){
            Log.d(TAG,"wif wif")
        }
    }

    fun dogHello(){
      val dog: Dog = Yorkshire()
      dog.sayHello()
    }
}