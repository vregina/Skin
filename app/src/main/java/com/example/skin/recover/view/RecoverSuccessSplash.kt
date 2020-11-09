package com.example.skin.recover.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.skin.R

class RecoverSuccessSplash : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recover_success_splash, container, false)
    }


//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        //INICIALIZAR TODOS OS COMPONENTES
//        activity?.let {
//
//
//        }
//    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RecoverSuccessSplash().apply {
                arguments = Bundle().apply {

                }
            }
    }
}