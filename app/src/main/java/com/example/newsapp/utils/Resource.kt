package com.example.newsapp.utils

sealed class Resource<out T> {
    object Loading : Resource<Nothing>()

    class Success<T>(val data: T) : Resource<T>()

    class Error(val error: String) : Resource<Nothing>()
}