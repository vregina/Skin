package com.example.skin.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.skin.R
import com.example.skin.addchore.view.AddChoreActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(findViewById(R.id.toolbar2))

        findViewById<BottomNavigationView>(R.id.bnv_menu)
            .setupWithNavController(
                findNavController(R.id.container_fragment)
            )
    }


    fun callAddChore() {
        startActivityForResult(AddChoreActivity.newIntent(context = baseContext), 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 0) {
            data?.getStringExtra(AddChoreActivity.TYPE)
            data?.getStringExtra(AddChoreActivity.DESCRIPTION)
            data?.getStringExtra(AddChoreActivity.DATETIME)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}