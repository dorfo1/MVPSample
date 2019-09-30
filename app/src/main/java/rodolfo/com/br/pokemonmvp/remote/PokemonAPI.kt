package rodolfo.com.br.pokemonmvp.remote

import retrofit2.Response
import retrofit2.http.GET
import rodolfo.com.br.pokemonmvp.model.Pokemon


interface PokemonAPI{


    @GET("pokemons.json")
    suspend fun getPokemons() : Response<List<Pokemon>>
}