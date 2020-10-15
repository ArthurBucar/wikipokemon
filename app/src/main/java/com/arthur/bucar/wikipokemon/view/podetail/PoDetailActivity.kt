package com.arthur.bucar.wikipokemon.view.podetail

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arthur.bucar.wikipokemon.R
import com.arthur.bucar.wikipokemon.adapter.PoAbilityListAdapter
import com.arthur.bucar.wikipokemon.adapter.PoMoveListAdapter
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.arthur.bucar.wikipokemon.model.Ability
import com.arthur.bucar.wikipokemon.connection.response.PoDetailResponse
import com.arthur.bucar.wikipokemon.model.Move
import com.arthur.bucar.wikipokemon.view.core.CoreActivity
import com.arthur.bucar.wikipokemon.view.polist.KEY_NAME
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_detail.*


class PoDetailActivity : CoreActivity(), PoDetailView {
    private var presenter: PoDetailPresenter? = null
    private var pokemonName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
        pokemonName = intent.getStringExtra(KEY_NAME)

        presenter = PoDetailPresenterImpl(this, PoDetailInteractorImpl())

        init()
    }

    private fun init() {
        presenter?.getPokemonDetail(pokemonName)
    }

    override fun setPokemonDetail(response: PoDetailResponse) {
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
        recyclerView?.adapter = abilities?.let { PoAbilityListAdapter(it, this) }
    }

    private fun setPokemonMoveListAdapter(recyclerView: RecyclerView?, moves: ArrayList<Move>?) {

        recyclerView?.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerView?.adapter = moves?.let { PoMoveListAdapter(it, this) }

    }

    override fun showErrorMessage(errorMessage: String) {
        Log.e("error", "errorMessage: $errorMessage")
    }
}
