package com.example.pokedex.api

data class PokemonCountResponse(
    val count: Int
)

data class PokemonVersionsResponse(
    val results: List<Version>
)

data class Version(
    val name: String,
    val url: String
)