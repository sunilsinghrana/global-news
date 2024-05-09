package com.example.newsapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import com.example.newsapp.domain.model.Article
import com.example.newsapp.presentation.components.ErrorState
import com.example.newsapp.presentation.components.HomeAppBar
import com.example.newsapp.presentation.components.LoadingItem
import com.example.newsapp.presentation.components.NewsItem
import com.example.newsapp.utils.Resource

@Composable
fun HomeScreen(
    navController: NavHostController,
) {
    val viewModel: HomeViewModel = hiltViewModel()
    val uiState = viewModel.allNewsResponse.collectAsState()

    Scaffold(
        topBar = { HomeAppBar()}
    ) {innerPadding ->

        //rest of data
        when (uiState.value) {
            is Resource.Loading -> {
                LoadingItem()
            }

            is Resource.Error -> {
                ErrorState()
            }

            else -> {
                val data = (uiState.value as Resource.Success).data
                LazyColumn(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
                    items(data.articles) { article ->
                        NewsItem(news = article, navHostController = navController)
                    }
                }
            }
        }

    }




}


