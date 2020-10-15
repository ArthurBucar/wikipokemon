package com.arthur.bucar.wikipokemon.connection.monitor

import android.text.TextUtils
import com.arthur.bucar.wikipokemon.connection.response.PoListResponse
import com.arthur.bucar.wikipokemon.view.polist.PoListInteractor

class PoListMonitor(private var listener: PoListInteractor.PokemonListListener) :
    BaseMonitor<PoListResponse>() {

    override fun onNext(response: PoListResponse) {
        listener.onPokemonListSuccess(response)
    }

    override fun onError(e: Throwable) {
        super.onError(e)
        if (!TextUtils.isEmpty(errorMessage)) {
            listener.onPokemonListFailed(e, errorMessage)
        }
    }

}