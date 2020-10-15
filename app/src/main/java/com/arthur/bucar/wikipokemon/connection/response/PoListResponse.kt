package com.arthur.bucar.wikipokemon.connection.response

import com.arthur.bucar.wikipokemon.model.Pokemon
import com.google.gson.annotations.SerializedName

class PoListResponse : BaseResponse() {

    @SerializedName("count")
    var count: Int? = null

    @SerializedName("results")
    var results: ArrayList<Pokemon>? = null

}