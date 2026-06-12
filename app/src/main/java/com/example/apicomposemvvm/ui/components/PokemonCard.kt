package com.example.apicomposemvvm.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.apicomposemvvm.data.model.PokemonItem

@Composable
fun PokemonCard(
    pokemon: PokemonItem
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Row(
            modifier = Modifier.padding(16.dp)
        ) {

            AsyncImage(
                model = pokemon.getImageUrl(),
                contentDescription = pokemon.name,
                modifier = Modifier.size(80.dp)
            )

            Spacer(
                modifier = Modifier.width(16.dp)
            )

            Text(
                text = pokemon.name
            )
        }
    }
}