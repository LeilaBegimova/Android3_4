package com.example.android3_4.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android3_4.databinding.ItemBinding
import com.example.android3_4.data.model.Result

class PokemonAdapter : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    private var pokemonList = mutableListOf<Result>()

    fun getPokemon(pokemon: List<Result>){
        this.pokemonList = pokemon.toMutableList()
    }

    inner class PokemonViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(pokemon: Result) {
            binding.itemPokemon.text = pokemon.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun getItemCount() = pokemonList.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.onBind(pokemonList[position])
    }
}