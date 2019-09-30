package rodolfo.com.br.pokemonmvp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import rodolfo.com.br.pokemonmvp.R
import rodolfo.com.br.pokemonmvp.databinding.RowPokemonBinding
import rodolfo.com.br.pokemonmvp.model.Pokemon

class PokemonAdapter(var pokemons: List<Pokemon>) : RecyclerView.Adapter<PokemonAdapter.PokemonHolder>(){


    private lateinit var listener: PokemonClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<RowPokemonBinding>(inflater,R.layout.row_pokemon,parent,false)

        var layoutParams = binding.root.layoutParams
        layoutParams.width = parent.width/2
        binding.root.layoutParams = layoutParams

        return PokemonHolder(binding)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        holder.binding.pokemon = pokemons[position]
        holder.binding.listener = listener
    }

    fun setOnPokemonClickListener(listener: PokemonClickListener){
        this.listener = listener
    }

    fun addPokemons(pokemons: List<Pokemon>) {
        this.pokemons = pokemons
        notifyDataSetChanged()
    }

    interface PokemonClickListener{
        fun onPokemonClickListener(pokemon : Pokemon)
    }

    class PokemonHolder(val binding: RowPokemonBinding) : RecyclerView.ViewHolder(binding.root)


}