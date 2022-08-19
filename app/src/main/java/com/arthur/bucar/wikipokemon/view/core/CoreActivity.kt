package com.arthur.bucar.wikipokemon.view.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


abstract class CoreActivity : AppCompatActivity(), InterfaceView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}
