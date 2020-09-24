package com.example.skin.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.skin.R
import com.example.skin.login.view.LoginFragment

class LoginActivity : AppCompatActivity() {

    val fragment = LoginFragment()
    val secondFragment = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(findViewById(R.id.toolbar))
        showLoginFragment()
    }

    fun segundoFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.container, secondFragment, "qlq2").commit()
    }

    fun voltar(){
        supportFragmentManager.popBackStack()
    }

    fun showLoginFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment, "qlq").commit()
    }
}