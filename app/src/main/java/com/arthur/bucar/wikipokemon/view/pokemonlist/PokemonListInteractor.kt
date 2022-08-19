package com.arthur.bucar.wikipokemon.view.pokemonlist

import com.arthur.bucar.wikipokemon.connection.response.PokemonListResponse

interface PokemonListInteractor {
    interface PokemonListListener {

        fun onPokemonListFailed(e: Throwable, errorMessage: String)

        fun onPokemonListSuccess(response: PokemonListResponse)
    }

    fun getPokemonList(listener: PokemonListListener)
}
