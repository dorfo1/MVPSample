package rodolfo.com.br.pokemonmvp.ui.detalhes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhes.*
import rodolfo.com.br.pokemonmvp.R
import rodolfo.com.br.pokemonmvp.model.Pokemon

class DetalhesActivity : AppCompatActivity() , DetalhesContract.View {

    private lateinit var presenter: DetalhesContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        setPresenter(DetalhesPresenter(this))
        var pokemon = intent.extras.getSerializable("Pokemon") as Pokemon
        presenter.onViewCreated(pokemon)
    }


    override fun showPokemonImg(url: String) {
        Picasso.get().load(url).into(ivPokemon)
    }

    override fun showPokemonNome(nome: String) {
        tvPokemonNome.text = nome
    }

    override fun showTipos(tipos: String) {
        tvPokemonTipo.text = tipos
    }

    override fun showFraquezas(fraquezas: String) {
        tvPokemonFraquezas.text = fraquezas
    }

    override fun showInfoAdicionais(info: String) {
       tvInfoAdicionais.text = info
    }

    override fun setPresenter(presenter: DetalhesContract.Presenter) {
        this.presenter = presenter
    }
}
