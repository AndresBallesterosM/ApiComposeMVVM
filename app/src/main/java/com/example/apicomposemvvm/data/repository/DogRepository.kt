package com.example.apicomposemvvm.data.repository

import com.example.apicomposemvvm.data.remote.RetrofitInstance

class DogRepository {

    suspend fun getRandomDog() =
        RetrofitInstance.dogApi.getRandomDog()
}