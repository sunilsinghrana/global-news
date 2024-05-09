package com.example.newsapp.domain.usecase

import com.example.newsapp.domain.model.News
import com.example.newsapp.domain.repository.NewsRepository
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(
        category: String,
        country : String
    ) : News{
        val response = newsRepository.getAllNews(category, country)
        if (response.body() == null) {
            if (response.code() == 404)
                throw Exception("No news found")
            else if (response.code() == 500)
                throw Exception("Server error")
            else if (response.code() == 401)
                throw Exception("Unauthorized")
            else if (response.code() == 400)
                throw Exception("Bad request")
            else
                throw Exception("No news found")
        }
        return newsRepository.getAllNews(category, country).body()!!
    }
}