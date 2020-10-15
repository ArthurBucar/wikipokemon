package com.arthur.bucar.wikipokemon.view.podetail

import com.arthur.bucar.wikipokemon.connection.baseconnection.ConnectionService
import com.arthur.bucar.wikipokemon.connection.monitor.PoDetailMonitor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PoDetailInteractorImpl : PoDetailInteractor {
    override fun getPokemonDetail(name: String?, listener: PoDetailInteractor.PokemonDetailListener) {
        ConnectionService.service()!!.getPokemonDetail(name)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(PoDetailMonitor(listener))
    }

}