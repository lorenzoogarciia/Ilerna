package com.example.pokedex.clases

import kotlin.random.Random

class Lucha(
    var pokemon1: Pokemon?,
    var pokemon2: Pokemon?
) {
    fun lucharPokemon(): String{
        //Implementacion del método para simular una lucha entre dos Pokemon
        var numIntentos: Int = 0
        var ataquePokemon1: Int = 0
        var ataquePokemon2: Int = 0

        //Verificar que ambos pokemon sean válidos
        if(pokemon1 == null || pokemon2 == null){
            return "No se puede simular la lucha, uno o ambos Pokémon son nulos."
        }

        var vidaPokemon1: Int = (pokemon1?.estadoBase ?: 0) + Random.nextInt(10000, 15000)
        var vidaPokemon2: Int = (pokemon2?.estadoBase ?: 0) + Random.nextInt(10000, 15000)
        val estadoBase1: Int = pokemon1?.estadoBase ?: 0
        val estadoBase2: Int = pokemon2?.estadoBase ?: 0

        //Varios intentos para bajar la vida
        do {
            ataquePokemon1 = Random.nextInt(0,estadoBase1)
            vidaPokemon2 -= ataquePokemon1
            ataquePokemon2 = Random.nextInt(0,estadoBase2)
            vidaPokemon1 -= ataquePokemon2
            numIntentos++
        }while (vidaPokemon1 > 0 && vidaPokemon2 > 0)

        var ganador: String? = "Empate"

        if(vidaPokemon1 > vidaPokemon2)
            ganador = pokemon1?.nombre
        else
            ganador = pokemon2?.nombre

        var informePelea: String = "Tras ${numIntentos} intentos\n " +
                "Ganador: ${ganador}\n" +
                "Vida ${pokemon1?.nombre}: ${vidaPokemon1}\n" +
                "Vida ${pokemon2?.nombre}: ${vidaPokemon2}\n"

        return informePelea
    }
}