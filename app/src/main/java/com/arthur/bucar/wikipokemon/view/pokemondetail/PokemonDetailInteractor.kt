package com.arthur.bucar.wikipokemon.view.pokemondetail

import com.arthur.bucar.wikipokemon.connection.response.PokemonDetailResponse

interface PokemonDetailInteractor {
    interface PokemonDetailListener {

        fun onPokemonDetailFailed(e: Throwable, errorMessage: String)

        fun onPokemonDetailSuccess(response: PokemonDetailResponse)
    }

    fun getPokemonDetail(name: String?, listener: PokemonDetailListener)
}
