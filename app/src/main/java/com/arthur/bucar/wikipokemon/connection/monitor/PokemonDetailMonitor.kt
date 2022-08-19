package com.arthur.bucar.wikipokemon.connection.monitor

import android.text.TextUtils
import com.arthur.bucar.wikipokemon.connection.response.PokemonDetailResponse
import com.arthur.bucar.wikipokemon.view.pokemondetail.PokemonDetailInteractor

class PokemonDetailMonitor(private var listener: PokemonDetailInteractor.PokemonDetailListener) :
    BaseMonitor<PokemonDetailResponse>() {
    var myRateConnection = false
    override fun onNext(response: PokemonDetailResponse) {
        listener.onPokemonDetailSuccess(response)
    }

    override fun onError(e: Throwable) {
        super.onError(e)
        if (!TextUtils.isEmpty(errorMessage)) {
            listener.onPokemonDetailFailed(e, errorMessage)
        }
    }

    fun testConnection(): Boolean {
        myRateConnection = true
        return myRateConnection
    }

}