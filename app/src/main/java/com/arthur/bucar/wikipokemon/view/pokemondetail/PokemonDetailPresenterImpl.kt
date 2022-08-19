package com.arthur.bucar.wikipokemon.view.pokemondetail

import com.arthur.bucar.wikipokemon.connection.response.PokemonDetailResponse


class PokemonDetailPresenterImpl(private var view: PokemonDetailView, private var interactor: PokemonDetailInteractor) :
    PokemonDetailPresenter, PokemonDetailInteractor.PokemonDetailListener {
    override fun onPokemonDetailFailed(e: Throwable, errorMessage: String) {
        view.showErrorMessage(errorMessage)
    }

    override fun onPokemonDetailSuccess(response: PokemonDetailResponse) {
        view.setPokemonDetail(response)
    }

    override fun getPokemonDetail(name: String?) {
        interactor.getPokemonDetail(name, this)
    }

    override fun onDestroy() {

    }

}