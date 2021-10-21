package com.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.ui.theme.Purple500
import com.compose.ui.theme.Purple700
import androidx.compose.material.Text as MaterialText

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeUi()
        }
    }

    @Composable
    fun ImageResourceDemo() {
        Image(
            modifier = Modifier.fillMaxSize(),
            bitmap = ImageBitmap.imageResource(id = R.drawable.background),
            contentScale = ContentScale.FillWidth,
            contentDescription = "contentDescription",
        )
    }


    @Preview
    @Composable
    private fun HomeUi() {
        val context = LocalContext.current
        val email = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }
        val emailErrorState = remember { mutableStateOf(false) }
        val passwordErrorState = remember { mutableStateOf(false) }
        val passwordVisibility = remember { mutableStateOf(true) }
        val scrollState = rememberScrollState()

        Scaffold(
            content = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    ImageResourceDemo()
                    Card(
                        modifier = Modifier
                            .padding(15.dp),
                        elevation = 10.dp,
                        shape = RoundedCornerShape(8.dp),
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(15.dp)
                                .verticalScroll(scrollState),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            MaterialText(text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Purple700, fontSize = 35.sp,
                                        fontFamily = FontFamily.Cursive,
                                        fontWeight = FontWeight.Bold,
                                        fontStyle = FontStyle.Italic,
                                        textDecoration = TextDecoration.None
                                    )
                                ) {
                                    append("S")
                                }
                                withStyle(style = SpanStyle(color = Color.Black)) {
                                    append("ign")
                                }

                                withStyle(
                                    style = SpanStyle(
                                        color = Purple700, fontSize = 35.sp,
                                        fontFamily = FontFamily.Cursive,
                                        fontWeight = FontWeight.Bold,
                                        fontStyle = FontStyle.Italic,
                                        textDecoration = TextDecoration.None
                                    )
                                ) {
                                    append(" I")
                                }
                                withStyle(style = SpanStyle(color = Color.Black)) {
                                    append("n")
                                }
                            }, fontSize = 30.sp)
                            Spacer(Modifier.size(16.dp))


                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {

                                OutlinedTextField(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = email.value,
                                    onValueChange = {
                                        if (emailErrorState.value) {
                                            emailErrorState.value = false
                                        }
                                        email.value = it
                                    },
                                    label = {
                                        MaterialText(text = "Enter your Email")
                                    },

                                    leadingIcon = {
                                        Icon(
                                            imageVector = Icons.Default.Email,
                                            contentDescription = "email"
                                        )
                                    },
                                    enabled = true,
                                    singleLine = true,
                                    readOnly = false,
                                    maxLines = 1,
                                    keyboardOptions = KeyboardOptions(
                                        capitalization = KeyboardCapitalization.None,
                                        autoCorrect = true,
                                        keyboardType = KeyboardType.Text,
                                        imeAction = ImeAction.Next
                                    ),
                                    textStyle = TextStyle(
                                        color = Color.Black,
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.SansSerif,
                                    ),

                                    )
                            }
                            if (emailErrorState.value) {
                                MaterialText(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(end = 10.dp),
                                    textAlign = TextAlign.End,
                                    text = "Required",
                                    color = colors.error,
                                    style = MaterialTheme.typography.caption,
                                )

                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                OutlinedTextField(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = password.value,
                                    onValueChange = {
                                        if (passwordErrorState.value) {
                                            passwordErrorState.value = false
                                        }
                                        password.value = it
                                    },
                                    label = {
                                        MaterialText(text = "Enter your Password")
                                    },

                                    leadingIcon = {
                                        Icon(
                                            imageVector = Icons.Default.Lock,
                                            contentDescription = "password"
                                        )
                                    },

                                    enabled = true,
                                    singleLine = true,
                                    readOnly = false,
                                    maxLines = 1,
                                    keyboardOptions = KeyboardOptions(
                                        capitalization = KeyboardCapitalization.None,
                                        autoCorrect = true,
                                        keyboardType = KeyboardType.Password,
                                        imeAction = ImeAction.Done
                                    ),
                                    textStyle = TextStyle(
                                        color = Color.Black,
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.SansSerif
                                    ),
                                    visualTransformation =
                                    if (passwordVisibility.value)
                                        PasswordVisualTransformation()
                                    else VisualTransformation.None,
                                    trailingIcon = {
                                        IconButton(onClick = {
                                            passwordVisibility.value = !passwordVisibility.value
                                        }) {
                                            Icon(
                                                imageVector = if (passwordVisibility.value)
                                                    Icons.Filled.VisibilityOff
                                                else
                                                    Icons.Filled.Visibility,
                                                contentDescription = "visibility",
                                                tint = Color.Black
                                            )

                                        }
                                    }
                                )
                            }

                            if (passwordErrorState.value) {
                                MaterialText(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(end = 10.dp),
                                    textAlign = TextAlign.End,
                                    text = "Required",
                                    color = colors.error,
                                    style = MaterialTheme.typography.caption,
                                )

                            }
                            Spacer(Modifier.size(16.dp))
                            Button(
                                onClick = {
                                    when {
                                        email.value.text.isEmpty() -> {
                                            emailErrorState.value = true
                                        }
                                        password.value.text.isEmpty() -> {
                                            passwordErrorState.value = true
                                        }
                                        else -> {
                                            passwordErrorState.value = false
                                            emailErrorState.value = false
                                            Toast.makeText(
                                                context,
                                                "Logged in successfully",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                            val data: String =
                                                email.value.text + " " + password.value.text
                                            Toast.makeText(
                                                context,
                                                "Welcome  $data",
                                                Toast.LENGTH_LONG
                                            )
                                                .show()
                                        }
                                    }

                                },
                                content = {
                                    MaterialText(text = "Login", color = Color.White)
                                },
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .padding(all = Dp(10F)),
                                enabled = true,
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor =
                                    Purple500
                                )
                            )
                            Spacer(Modifier.size(16.dp))


                        }
                    }
                }
            })
    }
}








