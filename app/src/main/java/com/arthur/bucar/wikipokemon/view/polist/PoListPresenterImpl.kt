package com.arthur.bucar.wikipokemon.view.polist

import com.arthur.bucar.wikipokemon.connection.response.PoListResponse


class PoListPresenterImpl(private var view: PoListView?, private var interactor: PoListInteractor?) :
    PoListPresenter, PoListInteractor.PokemonListListener {
    override fun onPokemonListFailed(e: Throwable, errorMessage: String) {
        view?.showErrorMessage(errorMessage)
    }

    override fun onPokemonListSuccess(response: PoListResponse) {
        view?.setPokemonList(response)
    }

    override fun getPokemonList() {
        interactor?.getPokemonList(this)
    }

    override fun onDestroy() {
        view = null
    }

}
