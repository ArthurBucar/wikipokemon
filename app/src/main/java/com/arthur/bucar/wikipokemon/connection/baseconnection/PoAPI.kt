package com.arthur.bucar.wikipokemon.connection.baseconnection

import com.arthur.bucar.wikipokemon.connection.response.PoDetailResponse
import com.arthur.bucar.wikipokemon.connection.response.PoListResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface PoAPI {

    @GET("api/v2/pokemon")
    fun getPokemonList(): Observable<PoListResponse>

    @GET("api/v2/pokemon/{name}")
    fun getPokemonDetail(@Path("name") name: String?): Observable<PoDetailResponse>
}