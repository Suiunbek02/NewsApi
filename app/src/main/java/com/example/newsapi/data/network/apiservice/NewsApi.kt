package com.example.newsapi.data.network.apiservice

import com.example.newsapi.API_KEY
import com.example.newsapi.model.NewsModel
import com.example.newsapi.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("/v2/everything")
    suspend fun fetchNews(
        @Query("q") query: String = "apple",
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY

    ): NewsResponse<NewsModel>
}