package com.example.todotutorial.presentation.task_details_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.todotutorial.R
import com.example.todotutorial.presentation.component.comman.TopBar
import com.example.todotutorial.ui.theme.orangeF34
import ir.kaaveh.sdpcompose.sdp

@Composable
fun TaskDetailsScreen(navigateBack: () -> Unit) {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopBar(navigateBack = { navigateBack() }, text = R.string.task_details)
        },

        ) { paddingValue ->

        Column {

            Text(
                modifier = Modifier.padding(paddingValue),
                text = stringResource(R.string.your_task_name)

            )
            Card(
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(20.sdp)
            ) {
                Text(text = stringResource(R.string.description))
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor. hello how are you this is me Abdul "
                )
            }
            Card(
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(20.sdp)
            ) {
                Row (modifier = Modifier.fillMaxWidth().padding(horizontal = 35.sdp)){
                    Text(text = stringResource(R.string.priority))
                    Box(modifier = Modifier.background(orangeF34)) {
                        Text(stringResource(R.string.high))
                    }
                }
                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 35.sdp)) {
                    Text(text = stringResource(R.string.due_date))
                    Text(text = "June 10, 2025")
                }
            }
            Row (modifier = Modifier.fillMaxWidth().padding(horizontal = 35.sdp)){
                Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.Transparent), modifier = Modifier.border(width = 2.sdp, color = orangeF34)) {
                    Text(color = orangeF34, text = stringResource(R.string.edit))
                }
                Button(onClick = {},colors = ButtonDefaults.buttonColors(Color.Transparent), modifier = Modifier.background(orangeF34)) {
                    Text(text = stringResource(R.string.completed))
                }
            }
        }

    }
}