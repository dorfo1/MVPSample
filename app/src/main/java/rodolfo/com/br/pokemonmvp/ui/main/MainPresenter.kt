package rodolfo.com.br.pokemonmvp.ui.main

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import rodolfo.com.br.pokemonmvp.model.Pokemon
import rodolfo.com.br.pokemonmvp.remote.getPokemonAPI
import java.lang.Exception

class MainPresenter(view: MainContract.View) : MainContract.Presenter {

    private var view: MainContract.View? = view

    private var job = Job()
    private var uiScope = CoroutineScope(Dispatchers.Main + job)


    override fun buscarPokemons() {
        view?.mostrarLoading()
        uiScope.launch {
            try {
                val response = getPokemonAPI().getPokemons()
                if (response.isSuccessful) {
                    response.body()?.let {
                        view?.addPokemons(it)
                    }
                } else {
                    view?.mostrarMsgErro("Falha na requisição ${response.message()}")
                }
            } catch (e: Exception) {
                view?.mostrarMsgErro("Falha ao consultar api ${e.message}")
            }
        }

    }

    override fun pokemonClickado(pokemon: Pokemon) {
        view?.irParaDetalhes(pokemon)
    }

    override fun onDestroy() {
        view = null
        job.cancel()
    }

}