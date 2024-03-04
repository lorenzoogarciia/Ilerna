package com.example.pokedex.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {
    @GET("pokemon/{id}")
    fun getPokemonById(@Path("id") id: Int): Call<PokemonResponse>

    @GET("pokemon/{name}")
    fun getPokemonByName(@Path("name") name: String): Call<PokemonResponse>

    @GET("pokemon")
    fun getTotalPokemons(): Call<PokemonCountResponse>

    @GET("version")
    fun getPokemonVersions(): Call<PokemonVersionsResponse>
}