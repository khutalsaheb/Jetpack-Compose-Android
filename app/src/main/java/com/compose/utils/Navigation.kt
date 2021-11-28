package com.compose.utils

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Splash : Screen("splash")
    object Details : Screen("details")
}