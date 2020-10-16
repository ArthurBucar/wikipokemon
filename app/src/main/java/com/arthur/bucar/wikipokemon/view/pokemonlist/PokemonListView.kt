package com.arthur.bucar.wikipokemon.view.pokemonlist

import com.arthur.bucar.wikipokemon.connection.response.PokemonListResponse
import com.arthur.bucar.wikipokemon.view.core.InterfaceView

interface PokemonListView : InterfaceView {
    fun setPokemonList(response: PokemonListResponse)
}
