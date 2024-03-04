package com.example.clientes_sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.database.database


class MainActivity : AppCompatActivity() {

    fun insertarClientesFirebase(listadoClientes: List<Cliente>){
        //Cogemos la referencia de la base de datos de Firebase
        val database = Firebase.database
        //Creamos la referencia de clientes
        val clientesRef = database.getReference("clientes")
        //Incluimos el listado de clientes en la base de datos de FireBase
        listadoClientes.forEach{cliente ->
            val key = clientesRef.push().key
            key?.let {
                clientesRef.child(it).setValue(cliente)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val c1 = Cliente("Lorenzo", "49136730J")
        val c2 = Cliente("Paloma", "58457843K")
        val c3 = Cliente("Diego", "56545422P")

        //Creamos la BBDD y añadimos los 3 clientes
        val bbddCliente = ClientesSQLite(this)
        bbddCliente.insert(c1)
        bbddCliente.insert(c2)
        bbddCliente.insert(c3)

        //Mostrar los clientes
        val listaClientes = bbddCliente.getListadoClientes()
        for(cliente in listaClientes){
            Log.i("MainActivity","Nombre: ${cliente.nombre} DNI: ${cliente.dni}")
        }

        //Vamos a crear una lista de clientes para FireBase
        val listadoClientes = listOf(
            Cliente("Lorenzo Garcia", "49136730J"),
            Cliente("Paloma Ramos", "48343458X"),
            Cliente("Artur Kurtaev","null"),
            Cliente("Jose Carlos","34932917J"),
            Cliente("Manuel Italia","56431829X")
        )
        insertarClientesFirebase(listadoClientes)
    }
}