package com.example.skin.recover.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.skin.R
import com.example.skin.register.view.RegisterFragment

class RecoverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover)
    }

//    fun showRecoverSetCodeFragment() {
//        val transaction = this.supportFragmentManager.beginTransaction()
//        val fragmentGoTo = RecoverSetCodeFragment()
//
//        transaction.replace(R.id.container, fragmentGoTo)
//        transaction.commit()
//
//    }
}