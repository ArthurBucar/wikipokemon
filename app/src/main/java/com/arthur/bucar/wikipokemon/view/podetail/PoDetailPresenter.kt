package com.arthur.bucar.wikipokemon.view.podetail

import com.arthur.bucar.wikipokemon.view.core.InterfacePresenter

interface PoDetailPresenter : InterfacePresenter {
    fun getPokemonDetail(name: String?)
}