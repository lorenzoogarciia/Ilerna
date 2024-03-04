package com.example.pokedex.api

import com.example.pokedex.clases.Pokemon

data class PokemonResponse(
    val id: Int,
    val name: String,
    val sprites: Sprites,
    val stats: List<Stat>
){
    fun toPokemon(): Pokemon{
        return Pokemon(
            id = this.id,
            nombre = this.name,
            imagen = this.sprites.front_default,
            estadoBase = this.stats.firstOrNull()?.base_stat ?: 0
        )
    }
}

data class Sprites(
    val front_default: String
)

data class Stat(
    val base_stat: Int
)