package com.arthur.bucar.wikipokemon.connection.response

import com.arthur.bucar.wikipokemon.model.Move
import com.arthur.bucar.wikipokemon.model.Sprite
import com.google.gson.annotations.SerializedName
import com.arthur.bucar.wikipokemon.model.Ability

class PokemonDetailResponse : BaseResponse() {

    @SerializedName("id")
    var id: Int? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("sprites")
    var sprites: Sprite? = null

    @SerializedName("moves")
    var moves: ArrayList<Move>? = null

    @SerializedName("weight")
    var weight: Int? = null

    @SerializedName("height")
    var height: Int? = null

    @SerializedName("abilities")
    var abilities: ArrayList<Ability>? = null
}