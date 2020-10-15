package com.arthur.bucar.wikipokemon.view.podetail

import com.arthur.bucar.wikipokemon.connection.response.PoDetailResponse


class PoDetailPresenterImpl(private var view: PoDetailView, private var interactor: PoDetailInteractor) :
    PoDetailPresenter, PoDetailInteractor.PokemonDetailListener {
    override fun onPokemonDetailFailed(e: Throwable, errorMessage: String) {
        view.showErrorMessage(errorMessage)
    }

    override fun onPokemonDetailSuccess(response: PoDetailResponse) {
        view.setPokemonDetail(response)
    }

    override fun getPokemonDetail(name: String?) {
        interactor.getPokemonDetail(name, this)
    }

    override fun onDestroy() {

    }

}