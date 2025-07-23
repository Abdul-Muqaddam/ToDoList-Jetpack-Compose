package com.example.todotutorial.presentation.log_in_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.todotutorial.R
import com.example.todotutorial.presentation.component.IntersectingCircleImage
import com.example.todotutorial.presentation.component.YellowButton
import com.example.todotutorial.ui.theme.greyD56
import com.example.todotutorial.ui.theme.greyEEE
import com.example.todotutorial.ui.theme.orangeF34
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp


@Composable
fun LogInScreen(navigateToDashboardScreen:()->Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = greyEEE)
    ) {
        IntersectingCircleImage()
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(modifier = Modifier
                .padding(bottom = 8.sdp)
                .weight(1f)) {
                Text(
                    modifier = Modifier
                        .padding(bottom = 8.sdp)
                        .fillMaxWidth(),
                    text = "Welcome Back!",
                    textAlign = TextAlign.Center,
                    fontSize = 28.ssp,
                    color = greyD56,
                    fontWeight = FontWeight.SemiBold
                )
                Image(
                    painter = painterResource(R.drawable.undraw_access_account_aydp),
                    contentDescription = null,

                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .height(160.sdp)

                )
            }
            Column(modifier = Modifier.weight(0.3f)) {

                TextField(
                    modifier = Modifier

                        .fillMaxWidth()
                        .padding(horizontal = 25.sdp),

                    value = "",
                    onValueChange = {},
                    placeholder = { Text(text = "Enter your Email") },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = Color.White
                    )

                )
            }
            Column(modifier = Modifier.weight(0.25f)) {

                TextField(
                    modifier = Modifier

                        .fillMaxWidth()
                        .padding(horizontal = 25.sdp),
                    value = "",
                    onValueChange = {},
                    placeholder = { Text(text = "Enter your Email") },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = Color.White
                    )
                )
            }
            Text(modifier = Modifier.weight(0.15f), text = "Forget Password", color = orangeF34)
            Column (modifier = Modifier.weight(0.25f)){

                YellowButton(navigatetoDashBoardScreen = navigateToDashboardScreen , text = "Login")
            }
            Row(
                modifier = Modifier
                    .weight(0.2f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = stringResource(R.string.already_have_an_account))
                Text(
                    text = stringResource(R.string.sign_in),
                    color = orangeF34,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.ssp
                )
            }
        }
    }
}