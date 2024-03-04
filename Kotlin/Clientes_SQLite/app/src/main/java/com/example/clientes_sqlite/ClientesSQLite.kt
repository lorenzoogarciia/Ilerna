package com.example.clientes_sqlite

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ClientesSQLite(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        private const val DATABASE_NAME = "Clientes.db"
        private const val DATABASE_VERSION = 1
    }

    //Métodos CRUD (Create Read Update Delete)
    override fun onCreate(db: SQLiteDatabase?) {
        //Crear la tabla "Clientes"
        val createTableQuery = """
            CREATE TABLE clientes(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT NOT NULL,
                dni TEXT NOT NULL
            )
        """.trimIndent()

        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //Eliminar la tabla "clientes" si ya existe y volver a crearla
        db?.execSQL("DROP TABLE IF EXISTS clientes")
        onCreate(db)
    }

    fun insert(nuevoCliente: Cliente): Long{
        return insert(nuevoCliente.nombre,nuevoCliente.dni)
    }

    private fun insert(nombre: String, dni: String): Long{
        val db = writableDatabase

        val values = ContentValues().apply{
            put("nombre", nombre)
            put("dni", dni)
        }

        val newRowId = db.insert("clientes", null, values)
        db.close()
        return newRowId
    }

    fun delete(idCliente: Int): Int{
        val db = writableDatabase
        val affectedRows = db.delete("clientes", "id = ?", arrayOf(idCliente.toString()))
        db.close()
        return affectedRows
    }

    fun update(idCliente: Int, cliente: Cliente): Int{
        val db = writableDatabase
        val values = ContentValues().apply {
            put("nombre", cliente.nombre)
            put("dni", cliente.dni)
        }

        val affectedRows = db.update("clientes", values, "id = ?", arrayOf(idCliente.toString()))
        db.close()
        return affectedRows
    }

    fun getNumeroClientes(): Int{
        val db = readableDatabase
        val selectQuery = "SELECT count(*) as numClientes FROM clientes"
        val cursor = db.rawQuery(selectQuery, null)

        cursor.use {
            if(it.moveToFirst()){
                db.close()
                return it.getInt(it.getColumnIndexOrThrow("numClientes"))
            }
        }

        cursor.close()
        db.close()
        return -1
    }

    @SuppressLint("Range")
    fun getListadoClientes(): List<Cliente>{
        val clientesList = mutableListOf<Cliente>()
        val db = readableDatabase
        val selectQuery = "SELECT * FROM clientes ORDER BY dni DESC"
        val cursor = db.rawQuery(selectQuery, null)

        cursor.use {
            if(it.moveToFirst()){
                do {
                    val nombre = cursor.getString(cursor.getColumnIndex("nombre"))
                    val dni = cursor.getString(cursor.getColumnIndex("dni"))
                    clientesList.add(Cliente(nombre, dni))
                }while (cursor.moveToNext())
            }
        }

        cursor.close()
        db.close()

        return clientesList
    }
}