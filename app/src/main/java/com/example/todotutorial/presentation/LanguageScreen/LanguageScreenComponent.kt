package com.example.todotutorial.presentation.LanguageScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.todotutorial.ui.theme.MyColors
import ir.kaaveh.sdpcompose.sdp


@Composable
fun LanguageScreenComponent(model: LanguagesModel, languageSelected: (String) -> Unit) {
    Card(
        onClick = {
            languageSelected(model.shortCode)
        },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(
            1.sdp,
            MyColors.orangeF34
        ),
        modifier = Modifier
            .width(150.sdp)
            .height(90.sdp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            Image(
                painter = painterResource(model.img),
                contentDescription = null,
                modifier = Modifier.size(30.sdp)
            )
            Text(text = model.languageName, modifier = Modifier.padding(top = 5.sdp))
            Text(
                text = model.nativeName, modifier = Modifier.padding(
                    top = 5.sdp
                )
            )
        }

    }
}
