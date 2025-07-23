package com.example.todotutorial.presentation.component.comman

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.todotutorial.R
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp


@Composable
fun TopBar(navigateBack:()->Unit,text:Int,color: Color= Color.Black){
    Row(
        modifier = Modifier.padding(top = 30.sdp, start = 15.sdp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
//            color=Color.White,
            modifier = Modifier.clickable { navigateBack() },
            painter = painterResource(R.drawable.ic_addnote_back_arrow),
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(start = 10.sdp),
            fontSize = 20.ssp,
            fontWeight = FontWeight.Bold,
            text = stringResource(text),
            color = Color.White
        )
    }
}