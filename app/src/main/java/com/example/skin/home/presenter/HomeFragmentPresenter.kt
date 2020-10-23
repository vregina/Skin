package com.example.skin.home.presenter

import com.example.skin.home.view.HomeFragment
import com.example.skin.home.view.Tarefa
import com.example.skin.model.ChoreResponse
import com.example.skin.model.LoginResponse
import com.example.skin.network.GetDataService
import com.example.skin.network.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Response

class HomeFragmentPresenter(private val view: HomeFragment) {

    var userChores = mutableListOf<Tarefa>()

    fun init() {
        getChoresMorning()
        getChoresNight()
    }

    private fun getChoresMorning() {
        view.hideTextEmptyListMorning()
        //mostrar um loading na tela home
        view.showLoading()
        //bater no backend
        val service =
            RetrofitClientInstance.getRetrofitInstance().create(GetDataService::class.java)
        val call = service.getChores()

        call.enqueue(
            object : retrofit2.Callback<List<ChoreResponse>> {
                override fun onFailure(call: Call<List<ChoreResponse>>, t: Throwable) {
                    val x = 1
                }

                override fun onResponse(
                    call: Call<List<ChoreResponse>>,
                    response: Response<List<ChoreResponse>>
                ) {
                    //adicionar a lista de tarefas
                    if (response.isSuccessful) {
                        userChores = response.body()?.map {
                            Tarefa(
                                it.title,
                                it.description,
                                it.done
                            )
                        }?.toMutableList()!!

                    } else {

                    }

                    //pegar o resultado


                    userChores.add(
                        Tarefa(
                            "Teste Title",
                            "Teste Description",
                            false
                        )
                    )
                    //esconder o loading na tela home
                    view.hideLoading()
                    //esconder msg de vazio

                    //chamar a view passando a lista de tarefas que veio do backend
                    view.updateChores(userChores)
                }
            }
        )
    }

    private fun getChoresNight() {
        //esconder msg de vazio
        view.hideTextEmptyListNight()
        //mostrar um loading na tela home
        view.showLoading()
        //bater no backend

        val service =
            RetrofitClientInstance.getRetrofitInstance()
                .create(GetDataService::class.java)
        val call = service.getChores()

        call.enqueue(
            object : retrofit2.Callback<List<ChoreResponse>> {
                override fun onFailure(call: Call<List<ChoreResponse>>, t: Throwable) {
                    val x = 1
                }

                override fun onResponse(
                    call: Call<List<ChoreResponse>>,
                    response: Response<List<ChoreResponse>>
                ) {
                    //adicionar a lista de tarefas
                    if (response.isSuccessful) {
                        userChores = response.body()?.map {
                            Tarefa(
                                it.title,
                                it.description,
                                it.done
                            )
                        }?.toMutableList()!!

                    } else {

                    }

                    //esconder o loading na tela home
                    view.hideLoading()


                    //chamar a view passando a lista de tarefas que veio do backend
                    setupNightChores(userChores)
                }
            }
        )
    }

    private fun setupMorningChores(list: MutableList<Tarefa>) {
        if (list.isEmpty()) {
            //chama funcao da view que mostra empty list
            view.showTextEmptyListMorning()
        } else {
            //chama funcao da view que esconde a empty list
            view.hideTextEmptyListMorning()
            //mostrar recycle view
            view.showRecyclerViewMorning()
            //add itens no recycler view
            view.updateChores(list)
        }
    }

    private fun setupNightChores(list: MutableList<Tarefa>) {
        if (list.isEmpty()) {
            //chama funcao da view que mostra empty list
            view.showTextEmptyListNight()
        } else {
            //chama funcao da view que esconde a empty list
            view.hideTextEmptyListNight()
            //mostrar recycle view
            view.showRecyclerViewNight()
            //add itens no recycler view
            view.updateChores(list)
        }

    }

    fun addChore(chore: Tarefa) {
        userChores.add(chore)
        view.updateChores(userChores)

    }


}
