package com.example.apicomposemvvm.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun DogCard(
    imageUrl: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        AsyncImage(
            model = imageUrl,
            contentDescription = "Dog",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
    }
}