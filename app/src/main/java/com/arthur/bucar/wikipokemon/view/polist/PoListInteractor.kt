package com.arthur.bucar.wikipokemon.view.polist

import com.arthur.bucar.wikipokemon.connection.response.PoListResponse

interface PoListInteractor {
    interface PokemonListListener {

        fun onPokemonListFailed(e: Throwable, errorMessage: String)

        fun onPokemonListSuccess(response: PoListResponse)
    }

    fun getPokemonList(listener: PokemonListListener)
}
