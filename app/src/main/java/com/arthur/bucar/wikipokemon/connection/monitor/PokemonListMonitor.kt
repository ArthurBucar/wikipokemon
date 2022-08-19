package com.arthur.bucar.wikipokemon.connection.monitor

import android.text.TextUtils
import com.arthur.bucar.wikipokemon.connection.response.PokemonListResponse
import com.arthur.bucar.wikipokemon.view.pokemonlist.PokemonListInteractor

class PokemonListMonitor(private var listener: PokemonListInteractor.PokemonListListener) :
    BaseMonitor<PokemonListResponse>() {

    override fun onNext(response: PokemonListResponse) {
        listener.onPokemonListSuccess(response)
    }

    override fun onError(e: Throwable) {
        super.onError(e)
        if (!TextUtils.isEmpty(errorMessage)) {
            listener.onPokemonListFailed(e, errorMessage)
        }
    }

}