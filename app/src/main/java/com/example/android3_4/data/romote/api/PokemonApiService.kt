package com.example.android3_4.data.romote.api

import com.example.android3_4.data.model.PockemonResponse
import retrofit2.Call
import retrofit2.http.GET

private const val POST_END_POINT = "ability/"

interface PokemonApiService {

    @GET(POST_END_POINT)
    fun getPosts(): Call<PockemonResponse>

}