package com.arthur.bucar.wikipokemon.view.pokemonlist

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.junit.Assert.*

import org.junit.Test

class PokemonListActivityTest {

    @Test
    fun onCreate() {
    }

    @Test
    fun setPokemonList() {
    }

    @Test
    fun showErrorMessage() {
    }

    @Test
    fun onPokemonClickedListener() {
    }

    @Test
    private fun pressBack() {
        UiDevice
            .getInstance(InstrumentationRegistry.getInstrumentation())
            .pressBack()
    }
}