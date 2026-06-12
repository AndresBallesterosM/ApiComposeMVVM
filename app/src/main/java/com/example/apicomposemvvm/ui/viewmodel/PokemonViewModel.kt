package com.example.apicomposemvvm.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicomposemvvm.data.model.PokemonListResponse
import com.example.apicomposemvvm.data.repository.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    private val repository = PokemonRepository()

    private val _pokemon =
        MutableStateFlow<UiState<PokemonListResponse>>(UiState.Loading)

    val pokemon: StateFlow<UiState<PokemonListResponse>>
        get() = _pokemon

    init {
        fetchPokemon()
    }

    private fun fetchPokemon() {

        viewModelScope.launch {

            try {

                val result = repository.getPokemonList()

                _pokemon.value = UiState.Success(result)

            } catch (e: Exception) {

                _pokemon.value =
                    UiState.Error(e.message ?: "Error")
            }
        }
    }
}