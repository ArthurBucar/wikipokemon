package com.arthur.bucar.wikipokemon.connection.baseconnection

import com.arthur.bucar.wikipokemon.connection.response.PokemonDetailResponse
import com.arthur.bucar.wikipokemon.connection.response.PokemonListResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonAPI {

    @GET("api/v2/pokemon")
    fun getPokemonList(): Observable<PokemonListResponse>

    @GET("api/v2/pokemon/{name}")
    fun getPokemonDetail(@Path("name") name: String?): Observable<PokemonDetailResponse>
}