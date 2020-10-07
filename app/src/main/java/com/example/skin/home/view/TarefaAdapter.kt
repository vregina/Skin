package com.example.skin.home.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.skin.R
import kotlinx.android.synthetic.main.item_home.view.*

class TarefaAdapter(val tarefas: MutableList<Tarefa>) :
    RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return TarefaViewHolder(view)
    }

    override fun getItemCount(): Int = tarefas.size

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        holder.bind(tarefas[position])
    }

    inner class TarefaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tarefa: Tarefa) {
            with(tarefa) {
                itemView.tv_nome_do_produto.text = nomeDoProduto.first().toString()
                itemView.tv_tipo_de_tratamento.text = tipoDeTratamento.first().toString()
                itemView.cb_home.isChecked = true
            }

        }
    }
}