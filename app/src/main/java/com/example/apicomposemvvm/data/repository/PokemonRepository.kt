package com.example.apicomposemvvm.data.repository

import com.example.apicomposemvvm.data.remote.RetrofitInstance

class PokemonRepository {

    suspend fun getPokemonList() =
        RetrofitInstance.pokemonApi.getPokemonList()
}