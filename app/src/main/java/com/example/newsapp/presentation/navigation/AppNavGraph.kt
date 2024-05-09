package com.example.newsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newsapp.presentation.components.NewsDetail
import com.example.newsapp.presentation.home.HomeScreen
import com.example.newsapp.presentation.splash.SplashScreen

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route ){
        composable(route = Screen.Splash.route){
            SplashScreen(navController)
        }
        composable(route = Screen.Home.route){
            HomeScreen(navController)
        }

        composable(
            Screen.Detail.route + "/{newsTitle}/{newsDescription}/{newsSourceName}/{newsDate}/{newsContent}/{newsImage}",
            arguments = listOf(
                navArgument("newsTitle") { type = NavType.StringType },
                navArgument("newsDescription") { type = NavType.StringType },
                navArgument("newsSourceName") { type = NavType.StringType },
                navArgument("newsDate") { type = NavType.StringType },
                navArgument("newsContent") { type = NavType.StringType },
                navArgument("newsImage") { type = NavType.StringType },
            )
        ) { backStackEntry ->
            NewsDetail(
                backStackEntry,
                navController
            )
        }
    }
    
}