package com.example.skin.recover.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.skin.R
import com.example.skin.home.view.HomeActivity
import com.example.skin.login.view.LoginActivity
import com.example.skin.register.view.RegisterSkinDetailsFragment

class RecoverPasswordFragment : Fragment() {


    lateinit var sendButton: Button

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
        return inflater.inflate(R.layout.fragment_recover_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //INICIALIZAR TODOS OS COMPONENTES
        activity?.let {
            sendButton = it.findViewById<Button>(R.id.bt_send)
        }

        sendButton.setOnClickListener {
            (activity as LoginActivity).showRecoverSetCodeFragment()
        }

    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RecoverPasswordFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

}