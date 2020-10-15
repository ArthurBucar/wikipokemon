package com.arthur.bucar.wikipokemon.view.podetail

import com.arthur.bucar.wikipokemon.connection.response.PoDetailResponse
import com.arthur.bucar.wikipokemon.view.core.InterfaceView

interface PoDetailView : InterfaceView {
    fun setPokemonDetail(response: PoDetailResponse)
}