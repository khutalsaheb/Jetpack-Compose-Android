package com.compose.activity

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.compose.R
import com.compose.ui.theme.Primary
import com.compose.ui.theme.typography
import com.compose.utils.BackgroundImage
import com.compose.utils.ImageLogo
import com.compose.utils.Screen

@Composable
fun RegistrationScreen(navController: NavController) {

    val context = LocalContext.current
    val email = remember { mutableStateOf(TextFieldValue()) }
    val fullName = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }
    val emailErrorState = remember { mutableStateOf(false) }
    val fullNameErrorState = remember { mutableStateOf(false) }
    val passwordErrorState = remember { mutableStateOf(false) }
    val passwordVisibility = remember { mutableStateOf(true) }
    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current


    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        BackgroundImage()
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(0.dp, 10.dp, 0.dp, 0.dp)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Box(
                modifier = Modifier
                    .height(240.dp)
                    .width(240.dp)
            )
            {
                ImageLogo()
            }
            Card(
                modifier = Modifier
                    .padding(15.dp),
                elevation = 10.dp,
                backgroundColor = Color.White,
                shape = RoundedCornerShape(8.dp),
            ) {
                Column(
                    modifier = Modifier
                        .padding(15.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    SignUpText()
                    Spacer(Modifier.size(16.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {

                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            value = fullName.value,
                            onValueChange = {
                                if (fullNameErrorState.value) {
                                    fullNameErrorState.value = false
                                }
                                fullName.value = it
                            },
                            label = {

                                Text(text = stringResource(id = R.string.full_name))
                            },

                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = "name"
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
                            textStyle = typography.body2,

                            )
                    }
                    if (fullNameErrorState.value) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                            textAlign = TextAlign.End,
                            text = stringResource(id = R.string.error_full_name),
                            color = MaterialTheme.colors.error,
                            style = typography.body2,

                            )

                    }

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

                                Text(text = stringResource(id = R.string.email))
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
                            textStyle = typography.body2,

                            )
                    }
                    if (emailErrorState.value) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                            textAlign = TextAlign.End,
                            text = stringResource(id = R.string.error_email),
                            color = MaterialTheme.colors.error,
                            style = typography.body2,

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
                                Text(text = stringResource(id = R.string.password))

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
                            keyboardActions = KeyboardActions(onDone =
                            { focusManager.clearFocus() }),
                            textStyle = typography.body2,
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
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                            textAlign = TextAlign.End,
                            text = stringResource(id = R.string.password_error),
                            color = MaterialTheme.colors.error,
                            style = typography.body2,
                        )

                    }
                    RegisterButton(
                        context,
                        fullName,
                        fullNameErrorState,
                        email,
                        emailErrorState,
                        password,
                        passwordErrorState, navController
                    )

                    Spacer(Modifier.size(5.dp))
                    LoginText(navController)
                    Spacer(Modifier.size(16.dp))
                }
            }
        }
    }
}

@Composable
fun LoginText(navController: NavController) {
    val annotatedText = buildAnnotatedString {
        //append your initial text
        withStyle(
            style = SpanStyle(
                color = Color.Gray,
            )
        ) {
            append(stringResource(id = R.string.already_have_account))

        }

        //Start of the pushing annotation which you want to color and make them clickable later
        pushStringAnnotation(
            tag = "SignIn",// provide tag which will then be provided when you click the text
            annotation = stringResource(id = R.string.already_have_account)
        )
        append(" ")
        //add text with your different color/style

        withStyle(
            style = SpanStyle(
                color = Color.Red,
            )
        ) {
            append(stringResource(id = R.string.login))
        }
        // when pop is called it means the end of annotation with current tag
        pop()
    }

    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = "SignIn",// tag which you used in the buildAnnotatedString
                start = offset,
                end = offset
            ).firstOrNull()?.let {
                navController.popBackStack()
                navController.navigate(Screen.Login.route)
            }
        }
    )
}

@Composable
fun SignUpText() {
    Text(text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Primary,
                fontSize = 35.sp
            )
        ) {
            append("S")
        }
        withStyle(style = SpanStyle(color = Color.Black)) {
            append("ign")
        }

        withStyle(
            style = SpanStyle(
                color = Primary,
                fontSize = 35.sp
            )
        ) { append(" U") }
        append("p")

    }, style = typography.body2)
}


@Composable
fun RegisterButton(
    context: Context,
    name: MutableState<TextFieldValue>,
    nameErrorState: MutableState<Boolean>,
    email: MutableState<TextFieldValue>,
    emailErrorState: MutableState<Boolean>,
    password: MutableState<TextFieldValue>,
    passwordErrorState: MutableState<Boolean>,
    navController: NavController
) {
    Button(
        onClick = {
            when {
                name.value.text.isEmpty() -> {
                    nameErrorState.value = true
                }
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
                        context.resources.getText(R.string.login_success),
                        Toast.LENGTH_SHORT
                    ).show()
                    navController.popBackStack()
                    navController.navigate(Screen.Login.route)
                }
            }

        },
        content = {
            Text(
                text = stringResource(id = R.string.sign_up), color = Color.White,
                style = typography.button
            )
        },

        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(all = 10.dp),
        enabled = true,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor =
            MaterialTheme.colors.secondary
        )
    )


}
