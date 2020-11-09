package com.example.skin.recover.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.skin.R
import com.example.skin.login.view.LoginActivity

class RecoverSetCodeFragment : Fragment() {

    lateinit var confirmButton: Button

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
        return inflater.inflate(R.layout.fragment_recover_set_code, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //INICIALIZAR TODOS OS COMPONENTES
        activity?.let {
            confirmButton = it.findViewById<Button>(R.id.bt_send)
        }

        confirmButton.setOnClickListener {
            (activity as LoginActivity).showRecoverSuccessSplah()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RecoverSetCodeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}