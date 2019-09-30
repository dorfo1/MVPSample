package rodolfo.com.br.pokemonmvp.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientAPI<T> {

    val url: String = "https://gist.githubusercontent.com/dorfo1/f11a4356a209b3d8681cbb3f092770fb/raw/c583bd91eacb2233d981b4e00cf6ff09eb7fd6f1/"


    fun getClient(c: Class<T>): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        return retrofit.create(c)
    }
}


fun getPokemonAPI(): PokemonAPI {
    return ClientAPI<PokemonAPI>().getClient(PokemonAPI::class.java)
}