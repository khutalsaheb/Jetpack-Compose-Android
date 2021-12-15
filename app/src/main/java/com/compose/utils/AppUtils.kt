package com.compose.utils

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.compose.R
import com.compose.data.model.Puppy

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
@Composable
fun PuppyImage(puppy: Puppy) {
    Image(
        painter = painterResource(id = puppy.puppyImageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        alignment=Alignment.Center,
        modifier = Modifier
            .padding(8.dp)
            .size(50.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}