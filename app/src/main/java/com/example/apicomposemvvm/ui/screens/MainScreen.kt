package com.example.apicomposemvvm.ui.screens

import androidx.compose.material3.*
import androidx.compose.runtime.*

@Composable
fun MainScreen() {

    var selectedTab by remember {
        mutableStateOf(0)
    }

    val tabs = listOf(
        "Pokémon",
        "Rick & Morty",
        "Dogs"
    )

    androidx.compose.foundation.layout.Column {

        TabRow(
            selectedTabIndex = selectedTab
        ) {

            tabs.forEachIndexed { index, title ->

                Tab(
                    selected = selectedTab == index,
                    onClick = {
                        selectedTab = index
                    },
                    text = {
                        Text(title)
                    }
                )
            }
        }

        when (selectedTab) {

            0 -> PokemonScreen()

            1 -> RickMortyScreen()

            2 -> DogScreen()
        }
    }
}