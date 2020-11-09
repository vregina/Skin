package com.example.skin.login.presenter

import com.example.skin.login.view.Forms
import com.example.skin.login.view.LoginFragment
import com.example.skin.model.LoginResponse
import com.example.skin.network.GetDataService
import com.example.skin.network.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Response

class LoginFragmentPresenter(private val view: LoginFragment) {

//    var emailDoUsuario = ""
//    var senhaDoUsuario = ""

    fun facaLogin(email: String, password: String) {

        val forms = Forms(email, password)

        val service =
            RetrofitClientInstance.getRetrofitInstance().create(GetDataService::class.java)
        val call = service.doLogin(forms)

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