package rodolfo.com.br.pokemonmvp.remote

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientAPI<T> {

    val url: String = "https://raw.githubusercontent.com/dorfo1/MVPSample/master/"


    fun getClient(c: Class<T>): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()


        return retrofit.create(c)
    }
}


fun getPokemonAPI(): PokemonAPI {
    return ClientAPI<PokemonAPI>().getClient(PokemonAPI::class.java)
}