package com.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Text as MaterialText

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeUi()
        }
    }

    @Preview
    @Composable
    private fun HomeUi() {
        val context = LocalContext.current
        val email = remember { mutableStateOf(TextFieldValue()) }
       // val emailErrorState = remember { mutableStateOf(false) }
      //  val passwordErrorState = remember { mutableStateOf(false) }
        val password = remember { mutableStateOf(TextFieldValue()) }
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        MaterialText(text = stringResource(id = R.string.text))
                    },
                    elevation = 0.dp
                )
            }
        ) {

            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
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
                        },/*
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "check"
                    )
                },*/
                        enabled = true,
                        singleLine = true,
                        readOnly = false,
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.None,
                            autoCorrect = true,
                            keyboardType = KeyboardType.Text,
                        ),
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontFamily = FontFamily.SansSerif
                        ),

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
                        },/*
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "check"
                    )
                },*/
                        visualTransformation = PasswordVisualTransformation(),
                        enabled = true,
                        singleLine = true,
                        readOnly = false,
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.None,
                            autoCorrect = true,
                            keyboardType = KeyboardType.Password,
                        ),
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontFamily = FontFamily.SansSerif
                        ),


                        )
                }
                Button(
                    onClick = {
                        val data:String= email.value.text+" "+password.value.text
                        Toast.makeText(context, "Welcome  ${data}", Toast.LENGTH_LONG)
                            .show()

                    },
                    modifier = Modifier.padding(all = Dp(10F)),
                    enabled = true,
                    border = BorderStroke(
                        width = 1.dp,
                        brush = SolidColor(Color.Blue)
                    ),
                    shape = MaterialTheme.shapes.medium,
                )
                {
                    MaterialText(
                        text = "Login",
                        color = Color.White
                    )
                }
            }
        }
    }
}







