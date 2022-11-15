package com.example.newsapi.model

import com.google.gson.annotations.SerializedName

data class NewsModel  (

    @SerializedName("author")
    val author: String?,

    @SerializedName("title")
    val title: String,

    @SerializedName("content")
    val content: String,

    @SerializedName("urlToImage")
    val urlToImage: String
)