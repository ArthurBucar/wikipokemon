package com.arthur.bucar.wikipokemon.view.pokemondetail

import com.arthur.bucar.wikipokemon.connection.baseconnection.ConnectionService
import com.arthur.bucar.wikipokemon.connection.monitor.PokemonDetailMonitor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PokemonDetailInteractorImpl : PokemonDetailInteractor {
    override fun getPokemonDetail(name: String?, listener: PokemonDetailInteractor.PokemonDetailListener) {
        ConnectionService.service()!!.getPokemonDetail(name)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(PokemonDetailMonitor(listener))
    }

}