package com.example.skin.model

import com.google.gson.annotations.SerializedName

class LoginResponse {

    @SerializedName("Token")
    val token: Int? = null

    @SerializedName("Error")
    val error: String = ""

}