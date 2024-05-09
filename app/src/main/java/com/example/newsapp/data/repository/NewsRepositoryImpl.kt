package com.example.newsapp.data.repository

import com.example.newsapp.data.web.NewsApi
import com.example.newsapp.domain.model.News
import com.example.newsapp.domain.repository.NewsRepository
import retrofit2.Response
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi,
) : NewsRepository {
    override suspend fun getAllNews(category: String, country: String): Response<News> {
        return api.getAllNews(category = category, country = country)
    }

    override suspend fun getNewsByName(q: String) : Response<News>{
        return api.getNewsByName(q)
    }

}