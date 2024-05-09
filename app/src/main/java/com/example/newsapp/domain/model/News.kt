package com.example.newsapp.domain.model

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
