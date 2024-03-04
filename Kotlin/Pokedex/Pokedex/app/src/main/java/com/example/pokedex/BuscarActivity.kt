package com.example.pokedex

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.room.Room
import com.bumptech.glide.Glide
import com.example.pokedex.api.PokeApiService
import com.example.pokedex.api.PokemonsInfo
import com.example.pokedex.clases.Pokemon
import com.example.pokedex.clases.PokemonDataBase
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class BuscarActivity : AppCompatActivity() {
    //El objeto de la BBDD para trabajar con ella
    companion object{
        lateinit var pokemonDataBase: PokemonDataBase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_buscar)

        //Configuramos la base de datos
        try {
            pokemonDataBase = Room.databaseBuilder(
                applicationContext,
                PokemonDataBase::class.java,
                "pokemon_database"
            ).build()
        }catch (e: Exception){
            e.printStackTrace()
        }

        //Mapeamos los botones de la Activity
        val btnVerInformacion = findViewById<Button>(R.id.btn_verInformacion_buscar)
        val btnAtras = findViewById<ImageButton>(R.id.btn_atras_buscar)
        val btnAtrapalo = findViewById<Button>(R.id.btn_atrapalo)

        //Mapeamos la imagen del Pokemon
        val imgPokemon = findViewById<ImageView>(R.id.img_pokemon_buscar)

        //Variable para el Pokémon actual
        var pokemon: Pokemon = Pokemon(0,"Prueba","Prueba",0)
        var pokemonId: Int? = null

        //Nos aparece un Pokemon aleatorio => que no esté en nuestra Pokédex
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiService = retrofit.create(PokeApiService::class.java)
        val pokemonsInfo = PokemonsInfo(apiService)

        //Llamada a la PokeApi...
        pokemonsInfo.getPokemonAleatorio { pokemonResponse ->
            if(pokemonResponse != null){
                pokemon = pokemonResponse.toPokemon()
                pokemonId = pokemon.id
                //Cargar imagen usando Glide
                Glide.with(this@BuscarActivity)
                    .load(pokemon.imagen)
                    .into(imgPokemon)
            }else{
                println("No se pudo encontrar un Pokemon aleatorio")
            }
        }

        //Programamos el botón Atrápalo
        btnAtrapalo.setOnClickListener{
            //Lanzamos una Coroutine en el hilo IO para la operación de la Base de Datos
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val pokemonDao = pokemonDataBase.pokemonDao()
                    pokemonDao.insert(pokemon)

                    //Cambiamos al hilo principal para actualizar la UI
                    withContext(Dispatchers.Main){
                        showToast("Pokémon ${pokemon.nombre} insertado en la Pokédex")
                    }
                }catch (e: Exception){
                    withContext(Dispatchers.Main){
                        showToast("No se ha podido insertar el Pokémon en la Base de Datos")
                    }
                    e.printStackTrace()
                }
            }
        }

        btnAtras.setOnClickListener {
            finish()
        }

        btnVerInformacion.setOnClickListener{
            val intent = Intent(this, InfoPokemonActivity::class.java)
            pokemonId.let {
                intent.putExtra("POKEMON_ID",it) //Pasar el ID del Pokémon como extra
            }
            startActivity(intent)
        }
    }

    private fun showToast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}