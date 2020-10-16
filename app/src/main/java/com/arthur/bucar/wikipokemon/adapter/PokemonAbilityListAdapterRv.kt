package com.arthur.bucar.wikipokemon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arthur.bucar.wikipokemon.R
import com.arthur.bucar.wikipokemon.model.Ability
import kotlinx.android.synthetic.main.item_ability.view.*

class PokemonAbilityListAdapterRv(
    private val dataList: ArrayList<Ability>,
    private val context: Context
) :
    RecyclerView.Adapter<PokemonAbilityListAdapterRv.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_ability, parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = dataList[position].ability?.name
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.tvAbilityName!!
    }
}