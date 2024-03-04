package com.example.pokedex

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.room.Room
import com.bumptech.glide.Glide
import com.example.pokedex.clases.Lucha
import com.example.pokedex.clases.Pokemon
import com.example.pokedex.clases.PokemonDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class InfoLuchaActivity : AppCompatActivity() {

    //Los elementos de la UI como atributos de la clase
    var imgRival1: ImageView? = null
    var imgRival2: ImageView? = null
    var informeLucha: TextView? = null

    //Los elementos de la pelea como atributos de la clase
    var rival1: Pokemon? = null
    var rival2: Pokemon? = null

    //El objeto de la BBDD para trabajar con ella
    companion object{
        lateinit var pokemonDataBase: PokemonDataBase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_info_lucha)

        //Configuramos la Base de Datos
        try {
            pokemonDataBase = Room.databaseBuilder(
                applicationContext,
                PokemonDataBase::class.java,
                "pokemon_database"
            ).build()
        }catch (e: Exception){
            e.printStackTrace()
        }

        CoroutineScope(Dispatchers.IO).launch {
            //Cargamos la Pokédex
            val pokemonDao = pokemonDataBase.pokemonDao()
            //Cargamos los pokemon por ID
            var rival1_ID: Int = intent.getIntExtra("rival1_ID", 0)
            var rival2_ID: Int = intent.getIntExtra("rival2_ID", 0)
            rival1 = pokemonDao.getPokemonById(rival1_ID)
            rival2 = pokemonDao.getPokemonById(rival2_ID)

            //Verificamos que ambos pokemon se han cargado antes de continuar
            if(rival1 != null && rival2 != null){
                //Mapeamos las imágenes y el texto
                imgRival1 = findViewById(R.id.img_pokemon_lucha1)
                imgRival2 = findViewById(R.id.img_pokemon_lucha2)
                informeLucha = findViewById(R.id.txt_info_lucha)

                //Cargamos las imágenes de los Pokémons
                cargarRivales()

                //Creamos la lucha y actualizamos el texto del informe de la pelea
                var lucha: Lucha = Lucha(rival1,rival2)
                var txtPelea: String = lucha.lucharPokemon()

                //Actualizamos la UI en el hilo principal
                runOnUiThread{
                    informeLucha?.text = txtPelea
                }
            }
        }

        val btnAtras = findViewById<ImageButton>(R.id.btn_atras_lucha2)
        btnAtras.setOnClickListener {
            finish()
        }
    }

    //Método para cargar las imágenes usando Glide
    private fun cargarRivales(){
        //Verificamos que rival1 y rival2 no sean nulos
        rival1?.let {pokemon1 ->
            imgRival1?.let {
                //Cargar imagen del rival1 utilizando Glide en el hilo principal
                runOnUiThread{
                    Glide.with(this@InfoLuchaActivity)
                        .load(pokemon1.imagen)
                        .into(it)
                }
            }
        }

        rival2?.let { pokemon2 ->
            imgRival2?.let {
                //Cargar la imagen de rival2 utilizando Glide en el hilo principal
                runOnUiThread{
                    Glide.with(this@InfoLuchaActivity)
                        .load(pokemon2.imagen)
                        .into(it)
                }
            }
        }
    }
}