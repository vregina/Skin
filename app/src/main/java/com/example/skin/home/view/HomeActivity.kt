package com.example.skin.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skin.R
import com.example.skin.rewards.view.RewardsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rv_teste.adapter = TarefaAdapter(fakeTarefas())
        rv_teste.layoutManager = LinearLayoutManager(this)

        setSupportActionBar(findViewById(R.id.toolbar2))

        findViewById<BottomNavigationView>(R.id.bnv_menu)
            .setupWithNavController(
                findNavController(R.id.container_fragment)
            )


    }
}