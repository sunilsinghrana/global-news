package com.example.newsapp.presentation.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapp.presentation.components.NewsButton
import com.example.newsapp.presentation.onboarding.components.OnBoardingPage

@Composable
fun OnBoardingScreen() {
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OnBoardingPage()
        NewsButton(text = "Get Started") {

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun OnBoardingScreenPrev() {
    OnBoardingScreen()
}