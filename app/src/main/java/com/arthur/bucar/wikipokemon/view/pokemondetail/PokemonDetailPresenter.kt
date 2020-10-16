package com.arthur.bucar.wikipokemon.view.pokemondetail

import com.arthur.bucar.wikipokemon.view.core.InterfacePresenter

interface PokemonDetailPresenter : InterfacePresenter {
    fun getPokemonDetail(name: String?)
}