package com.example.apicomposemvvm.data.model

data class PokemonListResponse(
    val count: Int,
    val results: List<PokemonItem>
)

data class PokemonItem(
    val name: String,
    val url: String
) {
    fun getImageUrl(): String {
        val id = url.trimEnd('/').split("/").last()

        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
    }
}