package com.example.pokedex.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonsInfo(private val apiService: PokeApiService) {

    fun getPokemonAleatorio(callback: (PokemonResponse?) -> Unit){
        apiService.getTotalPokemons().enqueue(object : Callback<PokemonCountResponse>{
            override fun onResponse(
                call: Call<PokemonCountResponse>,
                response: Response<PokemonCountResponse>
            ) {
                if(response.isSuccessful){
                    val total = 1015 //num máximo de pokemons a 15/12/2023
                    val randomId = (1..total).random()

                    apiService.getPokemonById(randomId).enqueue(object : Callback<PokemonResponse>{
                        override fun onResponse(
                            call: Call<PokemonResponse>,
                            response: Response<PokemonResponse>
                        ) {
                            if (response.isSuccessful){
                                callback(response.body())
                            }else{
                                callback(null)
                            }
                        }

                        override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                            callback(null)
                        }
                    })
                }else{
                    callback(null)
                }
            }

            override fun onFailure(call: Call<PokemonCountResponse>, t: Throwable) {
                callback(null)
            }
        })
    }

    fun getTotalPokemons(callback: (Int?) -> Unit){
        apiService.getTotalPokemons().enqueue(object : Callback<PokemonCountResponse> {
            override fun onResponse(call: Call<PokemonCountResponse>, response: Response<PokemonCountResponse>) {
                if (response.isSuccessful) {
                    callback(response.body()?.count)
                } else {
                    callback(null)
                }
            }

            override fun onFailure(call: Call<PokemonCountResponse>, t: Throwable) {
                callback(null)
            }
        })
    }

    fun getPokemonVersions(callback: (List<Version>?) -> Unit) {
        apiService.getPokemonVersions().enqueue(object : Callback<PokemonVersionsResponse> {
            override fun onResponse(call: Call<PokemonVersionsResponse>, response: Response<PokemonVersionsResponse>) {
                if (response.isSuccessful) {
                    callback(response.body()?.results)
                } else {
                    callback(null)
                }
            }

            override fun onFailure(call: Call<PokemonVersionsResponse>, t: Throwable) {
                callback(null)
            }
        })
    }
}