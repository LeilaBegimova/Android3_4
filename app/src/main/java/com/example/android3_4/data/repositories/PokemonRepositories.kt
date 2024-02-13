package com.example.android3_4.data.repositories

import android.util.Log
import com.example.android3_4.data.model.PockemonResponse
import com.example.android3_4.data.model.Result
import com.example.android3_4.data.romote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepositories {
    private val retrofitClient = RetrofitClient

    fun getPokemon(onRequest: (list: List<Result>) -> Unit, onFilure: (error: String) -> Unit) {
        retrofitClient.provideApiService.getPosts().enqueue(object : Callback<PockemonResponse> {
            override fun onResponse(
                call: Call<PockemonResponse>,
                response: Response<PockemonResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        Log.e("pokemon", "Is success: ${it}")
                        onRequest(it.results)
                    }
                }
            }

            override fun onFailure(call: Call<PockemonResponse>, t: Throwable) {
                Log.e("pokemon", "onFailure: ${t.message}")
            }

        })
    }
}