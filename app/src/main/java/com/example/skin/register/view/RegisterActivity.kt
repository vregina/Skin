package com.example.skin.register.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.skin.R

class RegisterActivity : AppCompatActivity() {

    val fragment1 = RegisterFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        showRegisterFragment()

//        val fragment1 = RegisterFragment()
//        supportFragmentManager.beginTransaction().replace(R.id.container_register, fragment1).commit()
//        val fragment2 = RegisterSkinToneFragment()

    }

    fun showRegisterFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment1, "qlq").commit()
    }

    fun showRegisterSkinToneFragment() {
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentGoTo = RegisterSkinToneFragment()

        transaction.replace(R.id.container, fragmentGoTo)
        transaction.commit()
    }
}