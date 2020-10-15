package com.arthur.bucar.wikipokemon.connection.monitor

import android.text.TextUtils
import com.arthur.bucar.wikipokemon.connection.response.PoDetailResponse
import com.arthur.bucar.wikipokemon.view.podetail.PoDetailInteractor

class PoDetailMonitor(private var listener: PoDetailInteractor.PokemonDetailListener) :
    BaseMonitor<PoDetailResponse>() {

    override fun onNext(response: PoDetailResponse) {
        listener.onPokemonDetailSuccess(response)
    }

    override fun onError(e: Throwable) {
        super.onError(e)
        if (!TextUtils.isEmpty(errorMessage)) {
            listener.onPokemonDetailFailed(e, errorMessage)
        }
    }

}