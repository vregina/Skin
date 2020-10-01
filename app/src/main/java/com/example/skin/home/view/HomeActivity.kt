package com.example.skin.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.skin.R
import com.example.skin.rewards.view.RewardsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    val homeFragment = HomeFragment()
    val rewardsFragment = RewardsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navView: BottomNavigationView = findViewById(R.id.bnv_menu)
        val navController = findNavController(R.id.container_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//        setSupportActionBar(findViewById(R.id.toolbar))
    }

    private fun showHomeFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.container, homeFragment, "qlq")
            .commit()
    }

    private fun showRewardsFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.container, rewardsFragment, "ll")
            .commit()
    }
}