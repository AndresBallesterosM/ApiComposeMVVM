package com.example.apicomposemvvm.data.repository

import com.example.apicomposemvvm.data.remote.RetrofitInstance

class RickMortyRepository {

    suspend fun getCharacters() =
        RetrofitInstance.rickMortyApi.getCharacters()
}