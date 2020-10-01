package com.example.skin.network

import com.example.skin.model.LoginRequest
import com.example.skin.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface GetDataService {

    @Multipart
    @POST("/auth")
    fun doLogin(@Part("user") user: String, @Part("password") password: String) : Call<LoginResponse>
//    fun doLogin(): Call<LoginResponse>
}