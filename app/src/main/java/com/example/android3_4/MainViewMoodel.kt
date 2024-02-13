package com.example.android3_4


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3_4.data.model.Result
import com.example.android3_4.data.repositories.PokemonRepositories
import com.example.android3_4.ui.utils.UiState

class MainViewMoodel : ViewModel() {
    private val pockemomResponse = PokemonRepositories()
    private var _pokemonLiveData = MutableLiveData<UiState<List<Result>>>()
    val postsLiveData: LiveData<UiState<List<Result>>> = _pokemonLiveData

    fun getPakemon() {
        pockemomResponse.getPokemon(onRequest = {
            _pokemonLiveData.value = UiState(isLoading = false, success = it)
        }, onFilure = {
            _pokemonLiveData.value = UiState(isLoading = false, error = "Error $it")
        })

    }

}