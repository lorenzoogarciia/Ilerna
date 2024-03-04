package com.example.pokedex

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
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

class LuchaActivity : AppCompatActivity() {
    //Los elementos de la UI como atributos de la clase
    var imgRival1: ImageView? = null
    var imgRival2: ImageView? = null
    var btnLuchar: Button? = null
    var btnAtras: ImageButton? = null

    //Elementos de la pelea como atributos de la clase
    var pokedex: Pokedex? = null
    var rival1: Pokemon? = null
    var rival2: Pokemon? = null

    //El objeto de la BBDD para trabajar con ella
    companion object{
        lateinit var pokemonDataBase: PokemonDataBase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_lucha)

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

        //Mapeamos las imágenes y los botones
        imgRival1 = findViewById<ImageView>(R.id.img_rival1)
        imgRival2 = findViewById<ImageView>(R.id.img_rival2)
        btnLuchar = findViewById<Button>(R.id.btn_luchar)
        btnAtras = findViewById<ImageButton>(R.id.btn_atras_lucha)

        //Lanzamos Corrutina para cargar los Pokemons de la Base de Datos
        CoroutineScope(Dispatchers.IO).launch {
            //Cargamos la Pokédex
            val pokemonDao = pokemonDataBase.pokemonDao()
            pokedex = Pokedex(pokemonDao)
            pokedex?.cargarListaPokemon()
            var numPokemons = pokedex?.numeroTotalPokemons()
            if(numPokemons != null){
                //Si no hay, al menos, 2 Pokémons => no permitimos luchar
                if(numPokemons < 2)
                habilitarLucha(false)
            }
        }
        //Preparamos la lucha
        prepararLucha()

        btnAtras?.setOnClickListener {
            finish()
        }

        btnLuchar?.setOnClickListener {
            val intent = Intent(this, InfoLuchaActivity::class.java)
            rival1?.id.let {
                intent.putExtra("rival1_ID", it) //Pasamos el ID del rival1
            }
            rival2?.id.let {
                intent.putExtra("rival2_ID", it) //Pasamos el ID del rival2
            }
            startActivity(intent)
        }
    }

    //Método para cargar las imágenes usando Glide
    private fun cargarRivales(){
        //Cargar imágenes usando Glide
        if(rival1 != null)
            imgRival1?.let {
                Glide.with(this@LuchaActivity)
                    .load(rival1?.imagen)
                    .into(it)
            }
        if(rival2 != null)
            imgRival2?.let {
                Glide.with(this@LuchaActivity)
                    .load(rival2?.imagen)
                    .into(it)
            }
    }

    private fun habilitarLucha(estado: Boolean){
        //Para que se haga en el hilo principal
        runOnUiThread{
            imgRival1?.isVisible = estado
            imgRival2?.isVisible = estado
            btnLuchar?.isEnabled = estado
            if(estado)
                btnLuchar?.text = "Luchar"
            else
                btnLuchar?.text = "No hay Pokémons"
        }
    }

    //La lucha va a ser aleatoria entre 2 pokémons de nuestra Pokédex
    private fun prepararLucha(){
        do {
            rival1 = pokedex?.obtenerPokemonAleatorio()
            rival2 = pokedex?.obtenerPokemonAleatorio()
        }while (rival2?.id == rival1?.id || rival1 == null)
        //Cargamos las imágenes
        cargarRivales()
    }
}