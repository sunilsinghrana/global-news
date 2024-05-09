package com.example.newsapp.domain.repository

import com.example.newsapp.domain.model.News
import retrofit2.Response

interface NewsRepository {
    suspend fun getAllNews(category: String, country: String): Response<News>
    suspend fun getNewsByName(q : String) : Response<News>
}