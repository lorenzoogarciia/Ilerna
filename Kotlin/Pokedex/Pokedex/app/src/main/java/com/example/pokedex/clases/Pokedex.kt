package com.example.pokedex.clases

//Define la clase Pokedex con su propiedad y métodos
class Pokedex(private val pokemonDao: PokemonDao) {
   private var listaPokemon: List<Pokemon> = emptyList()
   private var posicionActual: Int = 0

    suspend fun cargarListaPokemon(){
        listaPokemon = pokemonDao.getAllPokemons()
    }

    fun verPokemonActual(): Pokemon? {
        if (listaPokemon.isEmpty()){
            return null
        }
        return listaPokemon[posicionActual]
    }

    fun numeroTotalPokemons(): Int {
        return listaPokemon.size
    }

    fun irDerecha(){
        if (listaPokemon.isNotEmpty()){
            posicionActual = (posicionActual + 1) % listaPokemon.size
        }
    }

    fun irIzquierda(){
        if(listaPokemon.isNotEmpty()){
            posicionActual = if(posicionActual > 0){
                posicionActual -1
            }else{
                listaPokemon.size -1
            }
        }
    }

    fun obtenerPokemonAleatorio(): Pokemon? {
        if(listaPokemon.isEmpty()){
            return null
        }
        val indiceAleatorio = (0 until listaPokemon.size).random() //Genera un índice aleatorio
        return listaPokemon[indiceAleatorio]
    }
}