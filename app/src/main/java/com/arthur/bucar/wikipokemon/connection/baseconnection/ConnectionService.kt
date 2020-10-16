package com.arthur.bucar.wikipokemon.connection.baseconnection

import com.arthur.bucar.wikipokemon.util.ConfigurationUtilAPI
import com.daimajia.androidanimations.library.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ConnectionService {
    private var service: PokemonAPI? = null

    fun service(): PokemonAPI? {
        val httpClient = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            httpClient.addInterceptor(logging)
        }

        if (service == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(ConfigurationUtilAPI.baseUrl)
                .client(httpClient.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            service = retrofit.create(PokemonAPI::class.java)
        }

        return service
    }
}