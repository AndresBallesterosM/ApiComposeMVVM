package com.example.apicomposemvvm.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicomposemvvm.data.model.Character
import com.example.apicomposemvvm.data.repository.RickMortyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RickMortyViewModel : ViewModel() {

    private val repository = RickMortyRepository()

    private val _characters =
        MutableStateFlow<UiState<List<Character>>>(UiState.Loading)

    val characters: StateFlow<UiState<List<Character>>>
        get() = _characters

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {

        viewModelScope.launch {

            try {

                val response = repository.getCharacters()

                _characters.value =
                    UiState.Success(response.results)

            } catch (e: Exception) {

                _characters.value =
                    UiState.Error(e.message ?: "Error")
            }
        }
    }
}