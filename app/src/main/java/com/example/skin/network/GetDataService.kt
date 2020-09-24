package com.example.skin.network

import com.example.skin.model.LoginResponse
import retrofit2.Call
import retrofit2.http.POST

interface GetDataService {

    @POST("/auth")
    fun doLogin(): Call<LoginResponse>

//    @GET("/photos")
//    fun getAllPhotos(): Call<List<RetroPhoto>>

}