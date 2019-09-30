package rodolfo.com.br.pokemonmvp.ui.detalhes

import rodolfo.com.br.pokemonmvp.model.Pokemon

class DetalhesPresenter(view:DetalhesContract.View?) : DetalhesContract.Presenter{

   private var view : DetalhesContract.View? = view

    override fun onViewCreated(pokemon: Pokemon) {
        view?.showPokemonImg(pokemon.imageUrl)
        view?.showPokemonNome(pokemon.nome)
        view?.showFraquezas(transformarListaEmString(pokemon.fraquezas))
        view?.showTipos(transformarListaEmString(pokemon.types))
        view?.showInfoAdicionais("altura:${pokemon.altura}\npeso${pokemon.peso}")
    }

    override fun onDestroy() {
        view = null
    }

    fun transformarListaEmString(lista:List<String>) : String{
        var stringTransformada = ""
        for (s in lista){
            stringTransformada += "$s "
        }
        return stringTransformada
    }

}