package com.arthur.bucar.wikipokemon.view.pokemonlist

import com.arthur.bucar.wikipokemon.connection.baseconnection.ConnectionService
import com.arthur.bucar.wikipokemon.connection.monitor.PokemonListMonitor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PokemonListInteractorImpl : PokemonListInteractor {
    override fun getPokemonList(listener: PokemonListInteractor.PokemonListListener) {
        ConnectionService.service()!!.getPokemonList()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(PokemonListMonitor(listener))
    }

}
