package com.example.apicomposemvvm.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apicomposemvvm.ui.components.CharacterCard
import com.example.apicomposemvvm.ui.viewmodel.RickMortyViewModel
import com.example.apicomposemvvm.ui.viewmodel.UiState

@Composable
fun RickMortyScreen() {

    val vm: RickMortyViewModel = viewModel()

    val state by vm.characters.collectAsState()

    when (state) {

        is UiState.Loading -> {}

        is UiState.Success -> {

            val data = (state as UiState.Success).data

            LazyColumn {

                items(data) { character ->

                    CharacterCard(character)
                }
            }
        }

        is UiState.Error -> {}
    }
}