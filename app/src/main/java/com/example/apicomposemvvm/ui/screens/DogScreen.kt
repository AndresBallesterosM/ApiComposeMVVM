package com.example.apicomposemvvm.ui.screens

import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apicomposemvvm.ui.components.DogCard
import com.example.apicomposemvvm.ui.viewmodel.DogViewModel

@Composable
fun DogScreen() {

    val vm: DogViewModel = viewModel()

    val imageUrl by vm.dog.collectAsState()

    if (imageUrl.isNotEmpty()) {

        DogCard(
            imageUrl = imageUrl
        )
    }
}