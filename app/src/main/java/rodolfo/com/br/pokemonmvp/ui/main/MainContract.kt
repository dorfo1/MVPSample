package rodolfo.com.br.pokemonmvp.ui.main

import rodolfo.com.br.pokemonmvp.base.BasePresenter
import rodolfo.com.br.pokemonmvp.base.BaseView
import rodolfo.com.br.pokemonmvp.model.Pokemon

interface MainContract{

    interface Presenter : BasePresenter{
        fun buscarPokemons()

        fun pokemonClickado(pokemons : Pokemon)
    }


    interface View : BaseView<Presenter>{

        fun addPokemons(pokemons:List<Pokemon>)

        fun mostrarLoading()

        fun mostrarMsgErro(msg:String)

        fun irParaDetalhes(pokemons: Pokemon)

    }


}