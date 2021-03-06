package com.compose.activity

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.compose.R
import com.compose.utils.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(true) {
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(5f).getInterpolation(it)

                }
            )
        )
        delay(3000L)
        navController.popBackStack()
        navController.navigate(Screen.Login.route)
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        //  BackgroundImage()
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                .fillMaxSize()
        )
        {
            Box(
                modifier = Modifier
                    .height(dimensionResource(R.dimen.start_content_size))
                    .width(dimensionResource(R.dimen.start_content_size))
                    .clip(
                        RoundedCornerShape(8.dp)
                    )
                    .background(color = Color.Transparent)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .scale(scale.value),
                    painter = painterResource(id = R.drawable.android),
                    contentDescription = "Logo",
                )
            }
            /* Text(
                 text = "App Name",
                 modifier = Modifier.padding(bottom = dimensionResource(R.dimen.start_content_title_margin_bottom)),
                 color = Primary,
                 style = typography.h3
             )*/

        }
    }
}
