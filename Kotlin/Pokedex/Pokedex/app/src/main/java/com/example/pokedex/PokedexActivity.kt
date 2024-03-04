package com.example.pokedex

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.room.Room
import com.bumptech.glide.Glide
import com.example.pokedex.clases.Pokedex
import com.example.pokedex.clases.Pokemon
import com.example.pokedex.clases.PokemonDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class PokedexActivity : AppCompatActivity() {
    companion object {
        lateinit var pokemonDataBase: PokemonDataBase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_pokedex)

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

        //Mapeamos los botones de la UI
        val btnVerInformacion = findViewById<Button>(R.id.btn_verInformacion)
        val btnAtras = findViewById<ImageButton>(R.id.btn_atras_pokedex)
        val btnNavIzda = findViewById<ImageButton>(R.id.btn_izda)
        val btnNavDcha = findViewById<ImageButton>(R.id.btn_dcha)
        val btnBorrarPokedex = findViewById<ImageButton>(R.id.btn_limpiar_pokedex)

        //Mapeamos los datos del Pokemon a revisar
        val nombrePokemon = findViewById<TextView>(R.id.txt_nombre_pokemon)
        val imgPokemon = findViewById<ImageView>(R.id.img_pokemon)

        var pokedex: Pokedex? = null
        var pokemon: Pokemon? = null

        //Lanzamos Corrutina para cargar los Pokemons de la base de datos
        CoroutineScope(Dispatchers.IO).launch {
            //Cargamos la Pokedex
            val pokemonDao = pokemonDataBase.pokemonDao()
            pokedex = Pokedex(pokemonDao)
            pokedex?.cargarListaPokemon()
            pokemon = pokedex?.verPokemonActual()
            var numPokemons = pokedex?.numeroTotalPokemons()
            if(numPokemons != null){
                if(numPokemons > 0)
                    cargarInfoPokemonActual(pokemon,imgPokemon,nombrePokemon)
                else
                    cargarUISinPokemon(nombrePokemon)
            }
        }

        //Nos movemos a la izquierda en la lista de la Pokedex
        btnNavIzda.setOnClickListener{
            pokedex?.irIzquierda()
            pokemon = pokedex?.verPokemonActual()
            cargarInfoPokemonActual(pokemon,imgPokemon,nombrePokemon)
        }

        //Nos movemos a la derecha en la lista de la Pokedex
        btnNavDcha.setOnClickListener{
            pokedex?.irDerecha()
            pokemon = pokedex?.verPokemonActual()
            cargarInfoPokemonActual(pokemon,imgPokemon,nombrePokemon)
        }

        btnAtras.setOnClickListener {
            finish()
        }

        btnBorrarPokedex.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                //Cargamos la Pokedex
                val pokemonDao = pokemonDataBase.pokemonDao()
                pokemonDao.deleteAllPokemons()
            }
            cargarUISinPokemon(nombrePokemon)
        }

        btnVerInformacion.setOnClickListener{
            try {
                val intent = Intent(this, InfoPokemonActivity::class.java)
                pokemon?.id.let {
                    intent.putExtra("POKEMON_ID", it)//Pasar el ID del Pokemon
                }
                startActivity(intent)
            }catch (e: Exception){
                showToast("No se puede cargar la Info del Pokemon")
            }
        }
    }

    //Método para establecer la UI si no hay Pokemons
    private fun cargarUISinPokemon(nombrePokemon: TextView){
        nombrePokemon.text = "No hay Pokemons"
        habilitarBotones(false)
        imagenPorDefecto()
    }

    //Método para cargar la Info del Pokemon Actual
    private fun cargarInfoPokemonActual(
        pokemon: Pokemon?,
        imgPokemon: ImageView,
        nombrePokemon: TextView,
    ){
        //Verifica si estamos en el hilo principal (UI Thread)
        if(Looper.myLooper() == Looper.getMainLooper()){
            //Estamos en el hilo principal, puede cargar la imagen directamente
            cargarImagen(pokemon,imgPokemon,nombrePokemon)
        }else{
            //No estamos en el hilo principal, utiliza runOnUiThread para cargar la imagen en el hilo principal
            runOnUiThread{
                cargarImagen(pokemon,imgPokemon,nombrePokemon)
            }
        }
    }

    private fun imagenPorDefecto(){
        val imagenPokemon = findViewById<ImageView>(R.id.img_pokemon)
        val imagenID = resources.getIdentifier("buscando_pokemon","drawable",packageName)

        if (imagenID != 0){
            imagenPokemon.setImageResource(imagenID)
        }
    }

    private fun habilitarBotones(estado: Boolean){
        val btnVerInformacion = findViewById<Button>(R.id.btn_verInformacion)
        val btnNavIzda = findViewById<ImageButton>(R.id.btn_izda)
        val btnNavDcha = findViewById<ImageButton>(R.id.btn_dcha)
        val btnBorrarPokedex = findViewById<ImageButton>(R.id.btn_limpiar_pokedex)

        //Para que se haga en el hilo principal
        runOnUiThread{
            btnVerInformacion.isVisible = estado
            btnVerInformacion.isEnabled = estado
            btnNavIzda.isVisible = estado
            btnNavIzda.isEnabled = estado
            btnNavDcha.isVisible = estado
            btnNavDcha.isEnabled = estado
            btnBorrarPokedex.isVisible = estado
            btnBorrarPokedex.isEnabled = estado
        }
    }

    private fun cargarImagen(
        pokemon: Pokemon?,
        imgPokemon: ImageView,
        nombrePokemon: TextView
    ){
        //Cargar imagen usando Glide
        if(pokemon != null){
            nombrePokemon.text = pokemon.nombre
            Glide.with(this@PokedexActivity)
                .load(pokemon.imagen)
                .into(imgPokemon)
        }else{
            nombrePokemon.text = "No hay Pokémons"
        }
    }

    private fun showToast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}