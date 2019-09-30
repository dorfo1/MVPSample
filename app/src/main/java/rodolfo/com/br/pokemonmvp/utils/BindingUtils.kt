package rodolfo.com.br.pokemonmvp.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import rodolfo.com.br.pokemonmvp.model.Pokemon

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String?) {
    url?.let {
        Picasso.get().load(it).into(this)
    }
}

@BindingAdapter("setPokemonName")
fun TextView.setPokemonName(pokemon: Pokemon?) {
    pokemon?.let {
        text = pokemon.num + " - " + pokemon.nome
    }
}