package com.arthur.bucar.wikipokemon.view.polist

import com.arthur.bucar.wikipokemon.connection.baseconnection.ConnectionService
import com.arthur.bucar.wikipokemon.connection.monitor.PoListMonitor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PoListInteractorImpl : PoListInteractor {
    override fun getPokemonList(listener: PoListInteractor.PokemonListListener) {
        ConnectionService.service()!!.getPokemonList()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(PoListMonitor(listener))
    }

}
