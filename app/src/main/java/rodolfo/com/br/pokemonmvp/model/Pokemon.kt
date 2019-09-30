package rodolfo.com.br.pokemonmvp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Pokemon(
    val num : String,
    @SerializedName("name")
    val nome:String,
    @SerializedName("img")
    val imageUrl:String,
    @SerializedName("type")
    val types: List<String>,
    @SerializedName("weight")
    val peso: String,
    @SerializedName("height")
    val altura: String,
    @SerializedName("weaknesses")
    val fraquezas:List<String>) : Serializable
