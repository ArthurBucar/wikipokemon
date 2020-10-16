package com.arthur.bucar.wikipokemon.view.pokemondetail

import com.arthur.bucar.wikipokemon.connection.response.PokemonDetailResponse
import com.arthur.bucar.wikipokemon.view.core.InterfaceView

interface PokemonDetailView : InterfaceView {
    fun setPokemonDetail(response: PokemonDetailResponse)
}