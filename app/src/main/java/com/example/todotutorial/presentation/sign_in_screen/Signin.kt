package com.example.todotutorial.presentation.sign_in_screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import com.example.todotutorial.R
import com.example.todotutorial.presentation.component.IntersectingCircleImage
import com.example.todotutorial.presentation.component.YellowButton
import com.example.todotutorial.ui.theme.greyD56
import com.example.todotutorial.ui.theme.greyD56_80
import com.example.todotutorial.ui.theme.greyEEE
import com.example.todotutorial.ui.theme.orangeF34
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun Signin(navigateToLogInScreen:()->Unit) {


    var f_name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirm_password by remember { mutableStateOf("") }

    var isShowPassword by remember { mutableStateOf(false) }

    var isShowConfirmPassword by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = greyEEE)
    ) {


        IntersectingCircleImage()

        Column(modifier = Modifier.weight(0.3f)) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.welcome_onboarding),
                textAlign = TextAlign.Center,
                color = greyD56,
                fontSize = 26.ssp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.let_s_help_you_meet_up_your_tasks),
                textAlign = TextAlign.Center,
                color = greyD56_80
            )
        }
        Column(modifier = Modifier.weight(1f)) {

            TextField(

                modifier = Modifier

                    .fillMaxWidth()
                    .padding(horizontal = 25.sdp, vertical = 10.sdp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.sdp)),
                placeholder = { Text(text = stringResource(R.string.enter_your_full_name)) },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedTextColor = Color.Black

                ), value = f_name, onValueChange = {
                    f_name = it
                }
            )


            TextField(
                modifier = Modifier

                    .fillMaxWidth()
                    .padding(horizontal = 25.sdp, vertical = 10.sdp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.sdp)),
                placeholder = { Text(text = stringResource(R.string.enter_your_email)) },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedTextColor = Color.Black

                ), value = email, onValueChange = {
                    email = it
                }
            )


            TextField(
                modifier = Modifier

                    .fillMaxWidth()
                    .padding(horizontal = 25.sdp, vertical = 10.sdp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.sdp)),
                placeholder = { Text(text = stringResource(R.string.enter_password)) },
                visualTransformation = if (isShowPassword == true) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                trailingIcon = {
                    IconButton(onClick = {
                        isShowPassword = !isShowPassword
                    }) {

                        var icon = if (isShowPassword == true) {
                            painterResource(R.drawable.ic_hide_password)
                        } else {
                            painterResource(R.drawable.ic_show_password)
                        }

                        Icon(
                            painter = icon,
                            contentDescription = null
                        )
                    }

                },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedTextColor = Color.Black

                ), value = password, onValueChange = {
                    password = it
                }
            )


            TextField(
                modifier = Modifier

                    .fillMaxWidth()
                    .padding(horizontal = 25.sdp, vertical = 10.sdp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.sdp)),
                placeholder = { Text(text = stringResource(R.string.confirm_password)) },
                visualTransformation = if (isShowConfirmPassword == true) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                trailingIcon = {
                    var icon =
                        if (isShowConfirmPassword == true) {

                            painterResource(R.drawable.ic_hide_password)
                        } else {
                            painterResource(R.drawable.ic_show_password)
                        }
                    IconButton(onClick = {
                        isShowConfirmPassword = !isShowConfirmPassword
                    }) {
                        Icon(painter = icon, contentDescription = null)
                    }
                },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedTextColor = Color.Black

                ), value = confirm_password, onValueChange = {
                    confirm_password = it
                }
            )
        }
        Box(modifier = Modifier.weight(0.3f) ) {
            YellowButton(navigateToLoginInScreen = {
                navigateToLogInScreen()
            }, text = stringResource(R.string.register))
        }
        Row(
            modifier = Modifier
                .weight(0.2f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(R.string.already_have_an_account))
            Text(text = stringResource(R.string.sign_in), color = orangeF34 , fontWeight = FontWeight.Bold, fontSize = 15.ssp)
        }
    }
}