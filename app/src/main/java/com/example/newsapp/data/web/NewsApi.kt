package com.example.newsapp.data.web

import com.example.newsapp.domain.model.News
import com.example.newsapp.utils.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    suspend fun getAllNews(
        @Query("country") country : String,
        @Query("category") category: String,
        @Query("apiKey") apikey : String = Constant.API_KEY
    ): Response<News>

    @GET("everything")
    suspend fun getNewsByName(
        @Query("q") q : String = "technology",
        @Query("apiKey") apikey : String = Constant.API_KEY
    ): Response<News>
}