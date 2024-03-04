package com.example.pokedex.clases

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Pokemon::class], version = 1)
abstract class PokemonDataBase: RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}