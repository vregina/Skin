package com.example.skin.network

import com.example.skin.login.view.Forms
import com.example.skin.model.ChoreResponse
import com.example.skin.model.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface GetDataService {

//    @Multipart
    @POST("/api/auth/signin")
    fun doLogin(@Body form: Forms): Call<LoginResponse>
//    fun doLogin(@Part("email") email: Form, @Part("password") password: String) : Call<LoginResponse>


    @GET("/chores")
    fun getChores():Call<List<ChoreResponse>>

}