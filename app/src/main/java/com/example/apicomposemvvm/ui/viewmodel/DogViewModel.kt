package com.example.apicomposemvvm.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicomposemvvm.data.repository.DogRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {

    private val repository = DogRepository()

    private val _dog = MutableStateFlow("")

    val dog: StateFlow<String>
        get() = _dog

    init {
        fetchDog()
    }

    private fun fetchDog() {

        viewModelScope.launch {

            _dog.value =
                repository.getRandomDog().message
        }
    }
}