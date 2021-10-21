package com.compose

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_App_Starting)
        setContent {
            StartScreen()
        }
    }
}

@Preview
@Composable
fun StartScreen() {
    val activity = (LocalContext.current as? Activity)
    Scaffold(
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                ImageLogoBackground()
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(0.dp, 0.dp, 0.dp, 0.dp)
                        .fillMaxSize()
                ) {
                    Text(
                        stringResource(id = R.string.app_name),
                        fontSize = 36.sp,
                        modifier = Modifier.padding(bottom = dimensionResource(R.dimen.start_content_title_margin_bottom)),
                        color = Color.Black,
                        fontFamily= FontFamily.Cursive,
                        fontWeight = FontWeight.Bold
                    )
                    Box(
                        modifier = Modifier
                            .height(dimensionResource(R.dimen.start_content_size))
                            .width(dimensionResource(R.dimen.start_content_size))
                            .clip(
                                RoundedCornerShape(8.dp)
                            )
                            .background(color = Color.White)
                    ) {
                        ImageLogo()
                    }
                }
            }

            LaunchedEffect(true) {
                launch {
                    delay(2000)
                    activity?.startActivity(Intent(activity, MainActivity::class.java))
                    activity?.finish()
                }
            }
        }
    )

}

@Composable
fun ImageLogoBackground() {
    Image(
        modifier = Modifier.fillMaxSize(),
        bitmap = ImageBitmap.imageResource(
            id = R.drawable.background
        ),
        contentScale = ContentScale.FillWidth,
        contentDescription = "contentDescription",
    )
}

@Composable
fun ImageLogo() {
    Image(
        modifier = Modifier.fillMaxSize(),
        bitmap = ImageBitmap.imageResource(
            id = R.drawable.android
        ),
        contentDescription = "contentDescription",
    )
}