package com.compose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.compose.R


private val regular = Font(R.font.roboto_regular)
val appFontFamily = FontFamily(
    listOf(
        regular
    )
)

val typography = Typography(
    body1 = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.W100,
        fontSize = 20.sp
    ),
    h2 = TextStyle(
        fontSize = 60.sp,
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Thin,
        textAlign = TextAlign.Center,
    ),
    h3 = TextStyle(
        fontSize = 48.sp,
        fontFamily = appFontFamily,
        fontWeight = FontWeight.W100,
        textAlign = TextAlign.Center,

        ),
    h4 = TextStyle(
        fontSize = 28.sp,
        fontFamily = appFontFamily,
        fontWeight = FontWeight.W100,
    ),
    h5 = TextStyle(
        fontSize = 24.sp,
        fontFamily = appFontFamily,
        fontWeight = FontWeight.W100,
    ),
    h6 = TextStyle(
        fontSize = 20.sp,
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Normal,
    ),
    subtitle1 = TextStyle(
        fontSize = 18.sp,
        fontFamily = appFontFamily,
        fontWeight = FontWeight.W100,
    ),
    subtitle2 = TextStyle(
        fontSize = 16.sp,
        fontFamily = appFontFamily,
        fontWeight = FontWeight.W100,
    ),
    body2 = TextStyle(
        fontSize = 14.sp,
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Light,
    ),
    button = TextStyle(
        fontSize = 14.sp,
        fontStyle = FontStyle.Normal,
        letterSpacing = 4.sp,
        textAlign = TextAlign.Center,
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Bold,
    ),
    caption = TextStyle(
        fontSize = 12.sp,
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Normal,
    ),
    overline = TextStyle(
        fontSize = 10.sp,
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Normal,
    )
)