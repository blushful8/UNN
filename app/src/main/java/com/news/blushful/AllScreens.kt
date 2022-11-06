package com.news.blushful

sealed class AllScreens(val route: String){
    object MainScreen: AllScreens("main_screen")
    object DetailScree: AllScreens("detail_screen")
}
