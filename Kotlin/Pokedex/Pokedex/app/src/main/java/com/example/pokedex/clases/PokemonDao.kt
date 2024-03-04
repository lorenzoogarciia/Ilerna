package com.example.pokedex.clases

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PokemonDao {
    @Insert
    fun insert(pokemon: Pokemon)

    @Query("SELECT * FROM pokemons ORDER BY id")
    fun getAllPokemons(): List<Pokemon>

    @Query("SELECT * FROM pokemons WHERE id = :pokemonId")
    fun getPokemonById(pokemonId: Int): Pokemon?

    @Query("DELETE FROM pokemons WHERE id = :pokemonId")
    fun deleteById(pokemonId: Int)

    @Query("DELETE FROM pokemons")
    fun deleteAllPokemons()
}