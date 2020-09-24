package com.example.skin.model

import com.google.gson.annotations.SerializedName


class RetroPhoto(albumId: Integer, id: Integer, title: String, url: String, thumbnailUrl: String) {

    @SerializedName("albumId")
    private val albumId: Int? = null

    @SerializedName("id")
    private val id: Int? = null

    @SerializedName("title")
    private val title: String? = null

    @SerializedName("url")
    private val url: String? = null

    @SerializedName("thumbnailUrl")
    private val thumbnailUrl: String? = null

}