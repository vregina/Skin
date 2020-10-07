package com.example.skin.home.view

import android.widget.CheckBox

data class Tarefa(
    val tipoDeTratamento: String,
    val nomeDoProduto: String,
    val checkBox: CheckBox
)

class TarefaBuilder {
    var tipoDeTratamento: String = ""
    var nomeDoProduto: String = ""
    lateinit var checkBox: CheckBox

    fun build(): Tarefa =
        Tarefa(
            tipoDeTratamento,
            nomeDoProduto,
            checkBox
        )
}

fun tarefa(block: TarefaBuilder.() -> Unit): Tarefa = TarefaBuilder()
    .apply(block).build()

fun fakeTarefas():MutableList<Tarefa> = mutableListOf(
    tarefa {
        tipoDeTratamento = "Hidratação"
        nomeDoProduto = "Hydraboost"
        checkBox = checkBox
    },

    tarefa {
        tipoDeTratamento = "Proteção"
        nomeDoProduto = "Isdin"
        checkBox = checkBox
    },

    tarefa {
        tipoDeTratamento = "Ácido"
        nomeDoProduto = "Retinóico"
        checkBox = checkBox
    }

)