package com.example.skin.login.view

import android.content.ClipData.newIntent
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.skin.R
import com.example.skin.addchore.view.AddChoreActivity.Companion.newIntent
import com.example.skin.home.view.HomeActivity
import com.example.skin.recover.view.RecoverPasswordFragment
import com.example.skin.recover.view.RecoverSetCodeFragment
import com.example.skin.recover.view.RecoverSuccessSplash
import com.example.skin.register.view.RegisterActivity
import com.example.skin.register.view.RegisterFragment

class LoginActivity : AppCompatActivity() {

    val fragment = LoginFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
//        setSupportActionBar(findViewById(R.id.toolbar)
        showLoginFragment()

    }


    fun voltar(){
        supportFragmentManager.popBackStack()
    }

    fun showLoginFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment, "qlq").commit()
    }

    fun startHomeActivity(){
        startActivity(Intent(baseContext, HomeActivity::class.java))
    }

    fun showRegisterFragment() {
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentGoTo = RegisterFragment()

        transaction.replace(R.id.container, fragmentGoTo)
        transaction.commit()

    }

    fun showRecoverPasswordFragment() {
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentGoTo = RecoverPasswordFragment()

        transaction.replace(R.id.container, fragmentGoTo)
        transaction.commit()

    }

    fun showRecoverSetCodeFragment() {
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentGoTo = RecoverSetCodeFragment()

        transaction.replace(R.id.container, fragmentGoTo)
        transaction.commit()

    }

    fun showRecoverSuccessSplah() {
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentGoTo = RecoverSuccessSplash()

        transaction.replace(R.id.container, fragmentGoTo)
        transaction.commit()

    }
}