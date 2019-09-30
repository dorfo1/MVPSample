package rodolfo.com.br.pokemonmvp.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.ProgressBar
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import rodolfo.com.br.pokemonmvp.R
import rodolfo.com.br.pokemonmvp.model.Pokemon
import rodolfo.com.br.pokemonmvp.ui.detalhes.DetalhesActivity

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var presenter: MainContract.Presenter
    private lateinit var adapter: PokemonAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setPresenter(MainPresenter(this))
        presenter.buscarPokemons()


        adapter = PokemonAdapter(emptyList())
        rvPokemons.adapter = adapter
        rvPokemons.layoutManager = GridLayoutManager(this,2)


        adapter.setOnPokemonClickListener(object :PokemonAdapter.PokemonClickListener {
            override fun onPokemonClickListener(pokemon: Pokemon) {
               presenter.pokemonClickado(pokemon)
            }
        })



    }


    override fun addPokemons(pokemons: List<Pokemon>) {
        adapter.addPokemons(pokemons)
        progressbar.visibility = View.GONE
        msgErro.visibility = View.GONE
    }

    override fun mostrarLoading() {
        progressbar.visibility = View.VISIBLE
    }

    override fun mostrarMsgErro(msg: String) {
        if(msg.isNotEmpty()){
            progressbar.visibility = View.INVISIBLE
            msgErro.visibility = View.VISIBLE
            msgErro.text = msg
        }
    }

    override fun irParaDetalhes(pokemon : Pokemon) {
        val intent = Intent(applicationContext, DetalhesActivity::class.java)
        intent.putExtra("Pokemon",pokemon)
        startActivity(intent)
    }


    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }

}
