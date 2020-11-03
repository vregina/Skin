package com.example.skin.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientInstance {

    companion object {
        fun getRetrofitInstance(): Retrofit {

            val log = HttpLoggingInterceptor()
            log.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(log)

            return Retrofit.Builder().baseUrl("https://skare-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create()).client(httpClient.build()).build()
        }
    }

}

//"https://skare-api.herokuapp.com/
//https://private-126a5-skin.apiary-mock.com/
//
//val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
//    this.level = HttpLoggingInterceptor.Level.BODY
//}
//
//val client: OkHttpClient = OkHttpClient.Builder().apply {
//    this.addInterceptor(interceptor)
//}.build()