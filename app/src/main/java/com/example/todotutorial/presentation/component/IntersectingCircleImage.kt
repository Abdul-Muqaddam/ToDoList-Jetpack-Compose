package com.example.todotutorial.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.todotutorial.R
import ir.kaaveh.sdpcompose.sdp


@Composable
fun IntersectingCircleImage(){
    Image(
        modifier = Modifier

            .size(130.sdp)
            .offset(y = -5.sdp),
        painter = painterResource(R.drawable.circleshapes_yellow),
        contentDescription = null
    )
}