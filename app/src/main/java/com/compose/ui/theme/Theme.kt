package com.compose.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightThemeColors = lightColors(
    primary = Primary,
    secondary = Primary,
    background = Color.White,
    surface = Primary
)

private val DarkThemeColors = darkColors(
    primary = Primary,
    secondary = Primary,
    background = Color.Black,
    surface = Primary
)

@Composable
fun ComposeAppTheme(
    lightTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (lightTheme) LightThemeColors else DarkThemeColors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}