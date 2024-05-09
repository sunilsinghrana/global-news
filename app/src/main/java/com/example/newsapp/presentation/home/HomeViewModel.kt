package com.example.newsapp.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.model.News
import com.example.newsapp.domain.usecase.GetNewsUseCase
import com.example.newsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getNewsUseCase: GetNewsUseCase): ViewModel() {

    private val _allNewsResponse = MutableStateFlow<Resource<News>>(Resource.Loading)
    val allNewsResponse = _allNewsResponse as StateFlow<Resource<News>>

    private var job : Job? = null

    init {
             getNewsByCategory("general", "in")
    }

    private fun getNewsByCategory(category: String, country: String) {
        job?.cancel()
        job = viewModelScope.launch {
            _allNewsResponse.tryEmit(Resource.Loading)
            try {
                val newsResult = getNewsUseCase.invoke(category, country)
                _allNewsResponse.tryEmit(Resource.Success(newsResult))
                Log.d("viewModel", newsResult.toString())
            } catch (e: Exception) {
                _allNewsResponse.tryEmit(Resource.Error(e.message.toString()))
            }
        }
    }

}