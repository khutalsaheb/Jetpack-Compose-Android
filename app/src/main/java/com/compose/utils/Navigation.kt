package com.compose.utils

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Splash : Screen("splash")
    object Register : Screen("register")
    object Dashboard : Screen("dashboard")
    object Details : Screen("details")
}