package com.example.skin.home.view

import android.widget.CheckBox
import java.time.DateTimeException
import java.util.*

data class Tarefa(

    // tipo de tratamento não é mais string
    val tipoDeTratamento: String,
    val nomeDoProduto: String,
    val concluido: Boolean = false,
    val dateTime: String = Date().toString()
)
/*
class TarefaBuilder {
    var tipoDeTratamento: String = ""
    var nomeDoProduto: String = ""
    lateinit var concluido: Boolean

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

) */