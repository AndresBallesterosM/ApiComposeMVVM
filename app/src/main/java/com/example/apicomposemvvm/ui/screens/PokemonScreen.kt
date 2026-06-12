package com.example.apicomposemvvm.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apicomposemvvm.ui.components.PokemonCard
import com.example.apicomposemvvm.ui.viewmodel.PokemonViewModel
import com.example.apicomposemvvm.ui.viewmodel.UiState

@Composable
fun PokemonScreen() {

    val vm: PokemonViewModel = viewModel()

    val state by vm.pokemon.collectAsState()

    when (state) {

        is UiState.Loading -> {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is UiState.Success -> {

            val data = (state as UiState.Success).data

            LazyColumn {

                items(data.results) { pokemon ->

                    PokemonCard(
                        pokemon = pokemon
                    )
                }
            }
        }

        is UiState.Error -> {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                androidx.compose.material3.Text("Error cargando Pokémon")
            }
        }
    }
}