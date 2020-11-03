package com.example.skin.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.skin.R
import com.example.skin.addchore.view.AddChoreActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    lateinit var navBar: BottomNavigationView
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(findViewById(R.id.toolbar2))

        navController = findNavController(R.id.container_fragment)
        navBar = findViewById<BottomNavigationView>(R.id.bnv_menu).apply {
            setupWithNavController(navController)
        }
    }


    fun callAddChore() {
        startActivityForResult(AddChoreActivity.newIntent(context = baseContext), 0)
    }

    fun updateChoreFragment(chore: Tarefa) {
        navController.currentDestination.let {
            (it as? HomeFragment)?.let {
                it.recebeChore(chore)
            }
        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 0) {
            data?.let {
                val chore = Tarefa(
                    it.getStringExtra(AddChoreActivity.TYPE)!!,
                    it.getStringExtra(AddChoreActivity.DESCRIPTION)!!,
                    false,
                    it.getStringExtra(AddChoreActivity.DATETIME)!!
                )

                updateChoreFragment(chore)
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}