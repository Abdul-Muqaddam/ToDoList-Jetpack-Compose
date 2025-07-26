package com.example.todotutorial.presentation.task_details_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.todotutorial.R
import com.example.todotutorial.presentation.component.comman.TopBar
import com.example.todotutorial.ui.theme.MyColors
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun TaskDetailsScreen(navigateBack: () -> Unit) {
//    Scaffold(
//        containerColor = Color.White,
//        topBar = {
//            TopBar(navigateBack = { navigateBack() }, text = R.string.task_details)
//        },
//
//        ) { paddingValue ->

    Column(modifier = Modifier.padding(horizontal = 20.sdp)) {

        Row(modifier = Modifier.padding(top = 30.sdp)) {
            Image(
                contentDescription = null,
                painter = painterResource(R.drawable.ic_black_arrow),
                modifier = Modifier
                    .width(25.sdp)
                    .height(21.sdp)
                    .padding(start = 0.sdp, end = 0.sdp, top = 8.sdp, bottom = 0.sdp)
                    .clickable { navigateBack() }
            )
            Text(
                text = stringResource(R.string.task_details),
                fontSize = 22.ssp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 15.sdp)
            )
        }

        Text(
            text = stringResource(R.string.your_task_name),
            color = MyColors.orangeF34,
            modifier = Modifier
                .padding(start = 0.sdp, end = 0.sdp, top = 50.sdp, bottom = 0.sdp),
            fontSize = 18.ssp


        )
        Card(
            shape = RoundedCornerShape(30.sdp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(5.sdp),
            modifier = Modifier
                .padding(start = 0.sdp, end = 0.sdp, top = 25.sdp, bottom = 40.sdp)
                .height(233.sdp)
        ) {

            Text(
                text = stringResource(R.string.description),
                fontWeight = FontWeight.Bold,
                fontSize = 18.ssp,
                modifier = Modifier.padding(20.sdp)
            )

            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor. hello how are you this is me Abdul ",
                fontSize = 14.ssp,
                modifier = Modifier.padding(horizontal = 20.sdp)
            )
        }
        Column(modifier = Modifier.padding(horizontal = 20.sdp)) { }
        Card(
            shape = RoundedCornerShape(30.sdp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(5.sdp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.sdp)
                    .padding(horizontal = 20.sdp)

            ) {
                Text(
                    text = stringResource(R.string.priority),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.ssp
                )
                Card(


                    colors = CardDefaults.cardColors(MyColors.orangeF34),
                    elevation = CardDefaults.cardElevation(5.sdp),
                    modifier = Modifier
                        .width(55.sdp)
                        .height(25.sdp)
                        .background(
                            MyColors.orangeF34,
                            shape = RoundedCornerShape(10.sdp)
                        )
                ) {
                    Text(
                        stringResource(R.string.high),
                        fontSize = 14.ssp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 2.sdp)
                        //  .fillMaxWidth()
                        //  .fillMaxHeight()
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(top = 20.sdp, bottom = 20.sdp)
                    .padding(horizontal = 20.sdp)
                    .fillMaxWidth()

            ) {
                Text(
                    text = stringResource(R.string.due_date),
                    fontSize = 16.ssp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "June 10, 2025")
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(top = 50.sdp)
                .padding(horizontal = 5.sdp)
                .fillMaxWidth()
        ) {
            Button(
                onClick = {},
                shape = RoundedCornerShape(8.sdp),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                border = BorderStroke(2.sdp,MyColors.orangeF34)


            ) {
                Text(color = MyColors.orangeF34, text = stringResource(R.string.edit))
            }
            Button(
                onClick = {},
                shape = RoundedCornerShape(8.sdp),
                colors = ButtonDefaults.buttonColors(MyColors.orangeF34),
            ) {
                Text(text = stringResource(R.string.completed),
                    color = Color.White)
            }
        }
    }

}
