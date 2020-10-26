package com.example.skin.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.skin.R
import com.example.skin.home.presenter.HomeFragmentPresenter

class HomeFragment : Fragment() {

    private lateinit var presenter: HomeFragmentPresenter
    lateinit var recyclerViewNight: RecyclerView
    lateinit var recyclerViewMorning: RecyclerView
    lateinit var btPlusNight: LinearLayout
    lateinit var btPlusMorning: LinearLayout
    lateinit var progressBar: ProgressBar
    lateinit var tvEmptyListMorning: TextView
    lateinit var tvEmptyListNight: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

        presenter = HomeFragmentPresenter(this)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        //INICIALIZAR TODOS OS COMPONENTES
        activity?.let {
            recyclerViewNight = it.findViewById<RecyclerView>(R.id.rv_chores_night)
            recyclerViewMorning = it.findViewById<RecyclerView>(R.id.rv_chores_morning)
            btPlusNight = it.findViewById<LinearLayout>(R.id.bt_plus_night)
            btPlusMorning = it.findViewById<LinearLayout>(R.id.bt_plus_morning)
            progressBar = it.findViewById<ProgressBar>(R.id.pb_chores_night)
            tvEmptyListMorning = it.findViewById<TextView>(R.id.tv_empty_list_morning)
            tvEmptyListNight = it.findViewById<TextView>(R.id.tv_empty_list_night)
        }

        btPlusNight.setOnClickListener {
            (activity as HomeActivity).callAddChore()
        }

        btPlusMorning.setOnClickListener {
            (activity as HomeActivity).callAddChore()
        }

        //FAZER AS MUDANÇAS NECESSARIAS NOS COMPONENTES
        recyclerViewNight?.apply {
            adapter = TarefaAdapter(mutableListOf())
            layoutManager = LinearLayoutManager(activity)
        }

//        presenter.init()

        super.onActivityCreated(savedInstanceState)
    }

    fun updateChores(updatedList: List<Tarefa>) {
        //adicionar itens da lista no adapter do recyclerView
        recyclerViewNight?.adapter = TarefaAdapter(updatedList.toMutableList())

    }

    fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    fun showTextEmptyListMorning() {
        tvEmptyListMorning.visibility = View.VISIBLE

    }

    fun hideTextEmptyListMorning() {
        tvEmptyListMorning.visibility = View.GONE
    }

    fun showTextEmptyListNight() {
        tvEmptyListNight.visibility = View.VISIBLE

    }

    fun hideTextEmptyListNight() {
        tvEmptyListNight.visibility = View.GONE
    }

    fun showRecyclerViewMorning() {
        recyclerViewMorning.visibility = View.VISIBLE
    }

    fun hideRecyclerViewMorning() {
        recyclerViewMorning.visibility = View.GONE
    }

    fun showRecyclerViewNight() {
        recyclerViewNight.visibility = View.VISIBLE
    }

    fun hideRecyclerViewNight() {
        recyclerViewNight.visibility = View.GONE
    }

    fun recebeChore(chore: Tarefa) {
        presenter.addChore(chore)
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}