package rodolfo.com.br.pokemonmvp.ui.detalhes

import rodolfo.com.br.pokemonmvp.base.BasePresenter
import rodolfo.com.br.pokemonmvp.base.BaseView
import rodolfo.com.br.pokemonmvp.model.Pokemon

interface DetalhesContract {

    interface Presenter:BasePresenter{
        fun onViewCreated(pokemon: Pokemon)
    }

    interface View: BaseView<Presenter>{

        fun showPokemonImg(url:String)

        fun showPokemonNome(nome:String)

        fun showTipos(tipos:String)

        fun showFraquezas(fraquezas:String)

        fun showInfoAdicionais(info:String)
    }

}