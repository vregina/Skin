package com.example.skin.addchore.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.skin.R
import com.example.skin.home.view.Tarefa

class AddChoreActivity : AppCompatActivity() {


//    lateinit var spProductType: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_chore)

//        spProductType.findViewById<Spinner>(R.id.sp_product_type) as Spinner
//        val productType = arrayOf("hidratação", "protetor solar", "limpeza")
//        spProductType.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, productType)
//
//        spProductType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                TODO("Not yet implemented")
//            }
//        }



        supportFragmentManager.beginTransaction().add(R.id.ln_add_chore, AddChoreFragment())
            .commit()
    }

    fun termina(chore: Tarefa) {
        setResult(Activity.RESULT_OK, Intent().apply {
            putExtra(TYPE, chore.tipoDeTratamento)
            putExtra(DESCRIPTION, chore.nomeDoProduto)
            putExtra(DATETIME, chore.dateTime)
        })
        finish()
    }

    companion object {
        const val TYPE = "laalala"
        const val DESCRIPTION = "sasasa"
        const val DATETIME = "sass"
        fun newIntent(context: Context): Intent {
            return Intent(context, AddChoreActivity::class.java)
        }
    }

}