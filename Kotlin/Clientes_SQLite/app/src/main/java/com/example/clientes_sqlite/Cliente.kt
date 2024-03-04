package com.example.clientes_sqlite
/*
* Clase Cliente para almacenar en la Base de Datos
* */
class Cliente(var nombre:String, var dni: String) {

    override fun toString(): String{
        return "$dni - $nombre"
    }


}