package com.compose.utils

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import com.compose.R

@Composable
fun ShowToast(message: String) {
    Toast.makeText(LocalContext.current, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun BackgroundImage() {
    Image(
        modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth(1f),
        bitmap = ImageBitmap.imageResource(id = R.drawable.background),
        contentDescription = "contentDescription",
        contentScale = ContentScale.FillBounds
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