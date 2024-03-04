package com.example.pokedex

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.pokedex.api.PokeApiService
import com.example.pokedex.api.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InfoPokemonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_info_pokemon)

        val btnAtras = findViewById<ImageButton>(R.id.btn_atras_info_pokemon)
        val imgPokemon = findViewById<ImageView>(R.id.imageInfoPokemon)
        val nombrePokemon = findViewById<TextView>(R.id.txt_nombre_pokemon_buscar)
        val infoPokemon = findViewById<TextView>(R.id.txt_info_pokemon_buscar)

        //Vemos la info del Pokemon que buscamos
        val pokemonId = intent.getIntExtra("POKEMON_ID", -1)
        //Obtener el ID del Pokémon
        if(pokemonId != -1){
            val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val apiService = retrofit.create(PokeApiService::class.java)
            apiService.getPokemonById(pokemonId).enqueue(object : Callback<PokemonResponse> {
                override fun onResponse(
                    call: Call<PokemonResponse>,
                    response: Response<PokemonResponse>
                ) {
                    if(response.isSuccessful){
                        val pokemonResponse = response.body()
                        Glide.with(this@InfoPokemonActivity)
                            .load(pokemonResponse?.sprites?.front_default)
                            .into(imgPokemon)
                        nombrePokemon.text = pokemonResponse?.name
                        val baseHp = pokemonResponse?.stats?.firstOrNull()?.base_stat ?: "Desconocido"
                        infoPokemon.text = "ID($pokemonId) \nEstado Base: $baseHp"
                    }else {
                        println("No se pudo encontrar el Pokemon por ID")
                    }
                }

                override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                     println("Hubo un error al buscar el Pokemon")
                }
            })
        }

        btnAtras.setOnClickListener {
            finish()
        }

    }
}