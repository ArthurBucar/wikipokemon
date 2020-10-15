package com.arthur.bucar.wikipokemon.view.polist

import com.arthur.bucar.wikipokemon.connection.response.PoListResponse
import com.arthur.bucar.wikipokemon.view.core.InterfaceView

interface PoListView : InterfaceView {
    fun setPokemonList(response: PoListResponse)
}
