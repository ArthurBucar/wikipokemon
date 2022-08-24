package com.arthur.bucar.wikipokemon.connection.baseconnection

import com.arthur.bucar.wikipokemon.util.ConfigurationUtilAPI
import okhttp3.OkHttpClient
import org.junit.Assert.*

import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ConnectionServiceTest {
    @Test
    fun service() {
        var service: PokemonAPI? = null

        val httpClient = OkHttpClient.Builder()
        val retrofit = Retrofit.Builder()
            .baseUrl(ConfigurationUtilAPI.baseUrl)
            .client(httpClient.build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(PokemonAPI::class.java)

        assertNotNull(service)
    }
}