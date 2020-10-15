package com.arthur.bucar.wikipokemon.view.podetail

import com.arthur.bucar.wikipokemon.connection.response.PoDetailResponse

interface PoDetailInteractor {
    interface PokemonDetailListener {

        fun onPokemonDetailFailed(e: Throwable, errorMessage: String)

        fun onPokemonDetailSuccess(response: PoDetailResponse)
    }

    fun getPokemonDetail(name: String?, listener: PokemonDetailListener)
}
