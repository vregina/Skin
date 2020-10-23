package com.example.skin.addchore.presenter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.skin.R
import com.example.skin.addchore.view.AddChoreFragment
import com.example.skin.home.view.Tarefa


class AddChoreFragmentPresenter(private val view: AddChoreFragment) {

   var type: String = ""
   var time: String = ""

    //dropdown
    //horário de lembrete
    //dias que o lembrete serão setados
    //clicar no concluir quando tiver pronto

    fun finaliza() {

    }

    fun setChoreType(type: String) {
        this.type = type

    }

    fun setChoreTime(time: String) {
        this.time = time

    }

    fun setChoreName(name: String) {
        view.terminaERetorna(Tarefa(type, name, false, time))
    }
}