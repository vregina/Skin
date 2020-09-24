package com.example.skin.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.skin.R
import com.example.skin.login.presenter.LoginFragmentPresenter
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

    lateinit var presenter: LoginFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = LoginFragmentPresenter(this)
        val textEmail = view.findViewById<EditText>(R.id.editTextTextPersonName)

        val textSenha = view.findViewById<EditText>(R.id.editTextTextPersonName2)

        val buttonLogin = view.findViewById<Button>(R.id.bt_login)
        buttonLogin.setOnClickListener { v ->
            presenter.facaLogin(textEmail.text.toString(), textSenha.text.toString())
        }
    }

    fun loginSucesso(){
        Toast.makeText(view?.context, "Login feito com sucesso", Toast.LENGTH_LONG).show()
    }

    fun loginFracasso(){
        Toast.makeText(view?.context, "Login falhou, senha ou email incorretos", Toast.LENGTH_LONG).show()
    }
}