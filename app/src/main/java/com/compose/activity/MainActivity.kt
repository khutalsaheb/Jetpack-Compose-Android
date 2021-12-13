package com.compose.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.ui.theme.ComposeAppTheme
import com.compose.utils.Screen


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseComponent {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.Splash.route
                ) {
                    composable(Screen.Splash.route) {
                        SplashScreen(navController = navController)
                    }
                    composable(Screen.Login.route) {
                        LoginScreen(navController = navController)
                    }
                    composable(Screen.Register.route) {
                        RegistrationScreen(navController = navController)
                    }
                    composable(Screen.Dashboard.route) {
                        Dashboard()
                    }
/*
                composable("${Screen.Details.route}/{id}") {
                    BaseComponent {
                        DetailsScreen(coffee = it.arguments?.getString("id", "1")?.toInt()!!)
                    }
                }
*/
                }
            }
        }
    }
}

@Composable
fun BaseComponent(content: @Composable () -> Unit) {
    ComposeAppTheme {
        content()
    }
}
