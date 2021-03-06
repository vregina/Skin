package com.example.skin.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.skin.R
import com.example.skin.login.presenter.LoginFragmentPresenter

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

    lateinit var presenter: LoginFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        return inflater.inflate(R.layout.fragment_login_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = LoginFragmentPresenter(this)

        val textEmail = view.findViewById<EditText>(R.id.et_email_register)

        val textSenha = view.findViewById<EditText>(R.id.editTextTextPassword)

        val buttonRecoverPassword = view.findViewById<ConstraintLayout>(R.id.bt_recover_password)

        val buttonRegister = view.findViewById<ConstraintLayout>(R.id.bt_register)

        val buttonLogin = view.findViewById<Button>(R.id.bt_send)

        buttonLogin.setOnClickListener { v ->
            presenter.facaLogin((textEmail.text.toString()), textSenha.text.toString())
        }

        buttonRecoverPassword.setOnClickListener { v ->
            (activity as? LoginActivity)?.showRecoverPasswordFragment()
        }

        buttonRegister.setOnClickListener { v ->
            (activity as? LoginActivity)?.showRegisterFragment()
        }
    }

    fun loginSucesso() {
        Toast.makeText(view?.context, "Login feito com sucesso", Toast.LENGTH_LONG).show()
        (activity as? LoginActivity)?.startHomeActivity()
    }

    fun loginFracasso() {
        Toast.makeText(view?.context, "Login falhou, senha ou email incorretos", Toast.LENGTH_LONG)
            .show()
    }


}