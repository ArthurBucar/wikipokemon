package com.arthur.bucar.wikipokemon.view.polist

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arthur.bucar.wikipokemon.R
import com.arthur.bucar.wikipokemon.adapter.PoListAdapter
import com.arthur.bucar.wikipokemon.connection.response.PoListResponse
import com.arthur.bucar.wikipokemon.model.Pokemon
import com.arthur.bucar.wikipokemon.view.core.CoreActivity
import com.arthur.bucar.wikipokemon.view.podetail.PoDetailActivity
import kotlinx.android.synthetic.main.activity_pokemon_list.*

const val KEY_NAME = "name"

class PokemonListActivity : CoreActivity(), PoListView, PoListAdapter.PokemonListener {
    private var presenter: PoListPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        presenter = PoListPresenterImpl(this, PoListInteractorImpl())

        init()
    }

    private fun init() {
        presenter?.getPokemonList()
    }

    override fun setPokemonList(response: PoListResponse) {
        setPokemonListAdapter(rvPokemon, response)
    }

    private fun setPokemonListAdapter(recyclerView: RecyclerView?, response: PoListResponse) {
        recyclerView?.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerView?.adapter = PoListAdapter(response.results!!, this, this)
    }

    override fun showErrorMessage(errorMessage: String) {

    }

    override fun onPokemonClickedListener(pokemon: Pokemon) {
        val intent = Intent(this, PoDetailActivity::class.java)
        intent.putExtra(KEY_NAME, pokemon.name)
        startActivity(intent)
    }
}
