package com.arthur.bucar.wikipokemon.view.pokemondetail

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arthur.bucar.wikipokemon.R
import com.arthur.bucar.wikipokemon.adapter.PokemonAbilityListAdapterRv
import com.arthur.bucar.wikipokemon.adapter.PokemonMoveListAdapterRv
import com.arthur.bucar.wikipokemon.connection.response.PokemonDetailResponse
import com.arthur.bucar.wikipokemon.model.Ability
import com.arthur.bucar.wikipokemon.model.Move
import com.arthur.bucar.wikipokemon.view.core.CoreActivity
import com.arthur.bucar.wikipokemon.view.pokemonlist.KEY_NAME
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_detail.*


class PokemonDetailActivityView : CoreActivity(), PokemonDetailView {
    private var presenter: PokemonDetailPresenter? = null
    private var pokemonName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)

        val actionBar = supportActionBar!!
        actionBar.setHomeButtonEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)

        pokemonName = intent.getStringExtra(KEY_NAME)

        presenter = PokemonDetailPresenterImpl(this, PokemonDetailInteractorImpl())

        init()
    }

    private fun init() {
        presenter?.getPokemonDetail(pokemonName)
    }

    override fun setPokemonDetail(response: PokemonDetailResponse) {
        Picasso.with(this).load(response.sprites?.frontImage).into(ivImage)

        YoYo.with(Techniques.Tada)
            .duration(700)
            .repeat(5)
            .playOn(findViewById(R.id.ivImage))

        tvName.text = response.name
        tvWeight.text = "weight: ${response.weight.toString()}"
        tvHeight.text = "height: ${response.height.toString()}"
        setPokemonMoveListAdapter(rvMoves as RecyclerView?, response.moves)
        setPokemonAbilityListAdapter(rvAbilities as RecyclerView?, response.abilities)
    }

    private fun setPokemonAbilityListAdapter(recyclerView: RecyclerView?, abilities: ArrayList<Ability>?) {
        recyclerView?.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerView?.adapter = abilities?.let { PokemonAbilityListAdapterRv(it, this) }
    }

    private fun setPokemonMoveListAdapter(recyclerView: RecyclerView?, moves: ArrayList<Move>?) {

        recyclerView?.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerView?.adapter = moves?.let { PokemonMoveListAdapterRv(it, this) }

    }

    override fun showErrorMessage(errorMessage: String) {
        Log.e("error", "errorMessage: $errorMessage")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
