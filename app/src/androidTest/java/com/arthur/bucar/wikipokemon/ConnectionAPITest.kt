package com.arthur.bucar.wikipokemon

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.arthur.bucar.wikipokemon.connection.monitor.PokemonDetailMonitor
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ConnectionAPITest {
    @Test
    fun conectionAPITest() {
        var presenterConnetion: PokemonDetailMonitor? = null

        var result = presenterConnetion?.testConnection()

        if (result != null) {
            Assert.assertFalse(result)
        }
    }
}