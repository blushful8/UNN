package com.news.blushful

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationNews() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AllScreens.MainScreen.route) {
        composable(route = AllScreens.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = AllScreens.DetailScree.route + "/{detail}/{time}") {
            val detail = it.arguments?.getString("detail", "empty")!!
            val time = it.arguments?.getString("time", "empty")!!
            DetailScreen(detail, time)
        }
    }
}