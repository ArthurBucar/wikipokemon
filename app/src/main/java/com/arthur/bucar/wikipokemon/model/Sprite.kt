package com.arthur.bucar.wikipokemon.model

import com.google.gson.annotations.SerializedName

class Sprite {

    @SerializedName("front_default")
    var frontImage: String? = null

    @SerializedName("back_default")
    var backImage: String? = null

}
