package com.example.pokedex.clases

import androidx.room.Entity
import androidx.room.PrimaryKey
/**
 * Clase pokemon donde almacenaremos la informacion de un Pokemon
 * */

@Entity(tableName = "pokemons")
class Pokemon (
    @PrimaryKey
    val id: Int,
    val nombre: String,
    val imagen: String,
    val estadoBase: Int,
)