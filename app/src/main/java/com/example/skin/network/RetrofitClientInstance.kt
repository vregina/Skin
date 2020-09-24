package com.example.skin.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientInstance {

    companion object {
        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder().baseUrl("https://private-126a5-skin.apiary-mock.com/")
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }

}
