package com.example.skin.login.presenter

import android.widget.Toast
import com.example.skin.login.view.LoginFragment
import com.example.skin.model.LoginRequest
import com.example.skin.model.LoginResponse
import com.example.skin.network.GetDataService
import com.example.skin.network.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import javax.security.auth.callback.Callback

class LoginFragmentPresenter(private val view: LoginFragment) {
    var emailDoUsuario = ""
    var senhaDoUsuario = ""

    fun facaLogin(login: String, senha: String) {

        val service =
            RetrofitClientInstance.getRetrofitInstance().create(GetDataService::class.java)
        val call = service.doLogin(login, senha)

        call.enqueue(
            object : retrofit2.Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    val x = 1
                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        view.loginSucesso()
                    } else {
                        view.loginFracasso()
                    }
                }
            }
        )
    }
}