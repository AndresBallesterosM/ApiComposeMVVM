package com.example.apicomposemvvm.data.remote

import com.example.apicomposemvvm.data.model.*
import retrofit2.http.GET

interface PokemonApiService {

    @GET("pokemon?limit=20")
    suspend fun getPokemonList(): PokemonListResponse
}

interface RickMortyApiService {

    @GET("character")
    suspend fun getCharacters(): CharacterResponse
}

interface DogApiService {

    @GET("breeds/image/random")
    suspend fun getRandomDog(): DogResponse
}