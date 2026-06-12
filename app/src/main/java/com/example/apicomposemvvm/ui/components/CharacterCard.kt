package com.example.apicomposemvvm.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.apicomposemvvm.data.model.Character

@Composable
fun CharacterCard(
    character: Character
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier.size(120.dp)
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(character.name)

            Text(character.status)

            Text(character.species)
        }
    }
}