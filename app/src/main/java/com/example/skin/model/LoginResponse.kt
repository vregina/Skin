package com.example.skin.model

import com.google.gson.annotations.SerializedName

class LoginResponse {

    @SerializedName("token")
    val token: String? = null

    @SerializedName("Error")
    val error: String = ""

    @SerializedName("user")
    val user: String? = null

    @SerializedName("pwd")
    val pwd: String? = null

}