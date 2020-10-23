package com.example.skin.network

import com.example.skin.model.ChoreResponse
import com.example.skin.model.LoginRequest
import com.example.skin.model.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface GetDataService {

    @Multipart
    @POST("/auth")
    fun doLogin(@Part("user") user: String, @Part("password") password: String) : Call<LoginResponse>

    @GET("/chores")
    fun getChores():Call<List<ChoreResponse>>
}