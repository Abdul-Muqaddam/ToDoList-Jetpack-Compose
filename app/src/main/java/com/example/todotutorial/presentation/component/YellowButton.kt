package com.example.todotutorial.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.todotutorial.ui.theme.MyColors
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp


@Composable
fun YellowButton(
    navigatetoDashBoardScreen: () -> Unit = {},
    text: String
) {
    Button(
        onClick = { navigatetoDashBoardScreen() },
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 6.sdp),
        colors = ButtonDefaults.buttonColors(containerColor = MyColors.orangeF34),
        modifier = Modifier

            .fillMaxWidth()
            .height(48.sdp)
            .padding(horizontal = 20.sdp)
    ) {
        Text(fontSize = 22.ssp, text = text, color = Color.White)
    }
}