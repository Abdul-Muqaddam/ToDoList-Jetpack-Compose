package com.example.todotutorial.presentation.splash_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.todotutorial.R
import com.example.todotutorial.presentation.component.IntersectingCircleImage
import com.example.todotutorial.presentation.component.YellowButton
import com.example.todotutorial.ui.theme.MyColors
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun SplashScreen(navigateToDashboardScreen: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MyColors.greyEEE)
    ) {

        IntersectingCircleImage()
        Image(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            painter = painterResource(R.drawable.undraw_reminders),
            contentDescription = null
        )

        Column(modifier = Modifier.weight(0.3f)) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.1f),
                color = MyColors.greyD56,
                textAlign = TextAlign.Center,
                text = stringResource(R.string.gets_things_done_with_to_do),
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.ssp
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 50.sdp)
                    .weight(0.20f),
                color = MyColors.greyD56_80,
                textAlign = TextAlign.Center,
                text = stringResource(R.string.lorem_ipsum_dolar_set_amit_how_are_you_doing_this_is_to_do_application)
            )
        }
        Row(modifier = Modifier.weight(0.25f)) {

            YellowButton(navigatetoDashBoardScreen = {

                navigateToDashboardScreen()
            }, text = stringResource(R.string.get_started))

        }
    }
}