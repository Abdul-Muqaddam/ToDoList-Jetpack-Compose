package com.example.todotutorial.presentation.dashboard_screen.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun TaskBarIcon(img: Int, modifier: Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(img),
        contentDescription = null
    )
}