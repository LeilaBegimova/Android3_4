package com.example.android3_4

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.isVisible
import com.example.android3_4.databinding.ActivityMainBinding
import com.example.android3_4.ui.adapter.PokemonAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var biding: ActivityMainBinding
    private val viewMoodel: MainViewMoodel by viewModels()
    private val adapter = PokemonAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)
        viewMoodel.getPakemon()
        examination()
    }

    private fun examination() {
        viewMoodel.postsLiveData.observe(this) { uiState ->
            uiState?.let {
                biding.progressBar.isVisible = it.isLoading
                if (it.success != null) {
                    adapter.getPokemon(it.success)
                    biding.rvPokemon.adapter = adapter

                } else {
                    Toast.makeText(this, it.error, Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}