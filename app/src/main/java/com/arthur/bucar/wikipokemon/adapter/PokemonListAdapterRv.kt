package com.arthur.bucar.wikipokemon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arthur.bucar.wikipokemon.R
import com.arthur.bucar.wikipokemon.model.Pokemon
import kotlinx.android.synthetic.main.item_pokemon.view.*

class PokemonListAdapterRv(
    private val dataList: ArrayList<Pokemon>,
    private val context: Context,
    private val listener: PokemonListener
) :
    RecyclerView.Adapter<PokemonListAdapterRv.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_pokemon, parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = dataList[position].name
        holder.container.setOnClickListener {
            listener.onPokemonClickedListener(dataList[position])
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.tvName!!
        val container = itemView.pokemonContainer!!
    }

    interface PokemonListener {
        fun onPokemonClickedListener(pokemon: Pokemon)
    }
}