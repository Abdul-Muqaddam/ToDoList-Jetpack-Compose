package com.example.todotutorial.presentation.dashboard_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.todotutorial.R
import com.example.todotutorial.presentation.dashboard_screen.components.CurrentTask
import com.example.todotutorial.presentation.dashboard_screen.components.TaskBarIcon
import com.example.todotutorial.ui.theme.orangeF34
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp
import android.util.Log


@Composable
fun DashboardScreen(onNavigateToTaskDetailsScreen:()->Unit, navigateToAddToDoScreen:()->Unit) {
    var isChecked by remember { mutableStateOf(false) }
    Column {
        Column(modifier = Modifier.weight(1f)) {

            Box(
                modifier = Modifier

                    .shadow(
                        elevation = 6.sdp,
                        shape = RoundedCornerShape(bottomStart = 50.sdp, bottomEnd = 50.sdp)
                    )
                    .background(
                        color = orangeF34,
                        shape = RoundedCornerShape(bottomStart = 50.sdp, bottomEnd = 50.sdp)
                    )
                    .fillMaxWidth()
            ) {
                Column {
                    Image(
                        modifier = Modifier

                            .size(130.sdp)
                            .offset(y = -5.sdp),
                        painter = painterResource(R.drawable.circleshapes_white),
                        contentDescription = null
                    )


                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = -40.sdp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            modifier = Modifier.size(100.sdp),
                            painter = painterResource(R.drawable.ellipse12),
                            contentDescription = null
                        )
                        Text(
                            modifier = Modifier.padding(vertical = 5.sdp),
                            text = "Welcome Emma",
                            color = Color.White,
                            fontSize = 28.ssp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier.size(100.sdp),
                painter = painterResource(R.drawable.group69),
                contentDescription = null
            )
        }
        Column() {
            Text(
                modifier = Modifier.padding(horizontal = 25.sdp),
                fontWeight = FontWeight.Bold,
                fontSize = 20.ssp,
                text = "Pending Task",
                color = orangeF34
            )
            Column (modifier = Modifier.clickable {
                onNavigateToTaskDetailsScreen()
            }){

                CurrentTask(
                    img = if (isChecked == true) {
                        R.drawable.ic_dashboard_checkmark
                    } else {
                        R.drawable.ic_dashboard_emptycheckmark
                    },
                    text = R.string.learn_desiging,
                    isCheckedClicked = {
                        isChecked=it
                    }
                )
            }
//            CurrentTask(
//                img = R.drawable.ic_dashboard_emptycheckmark,
//                text = R.string.learn_development
//            )


        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 26.sdp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.clickable { navigateToAddToDoScreen() }
                    .padding(end = 5.sdp)
                    .size(40.sdp)
                    .background(orangeF34, shape = RoundedCornerShape(50.sdp))
            ) {
                Image(
                    modifier = Modifier.size(18.sdp),
                    painter = painterResource(R.drawable.ic_dashboard_plus),
                    contentDescription = null
                )
            }
            Box(modifier = Modifier.offset(y = -25.sdp)) {
                Image(
                    painter = painterResource(R.drawable.taskbar),
                    contentDescription = null,
                    modifier = Modifier
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.sdp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    TaskBarIcon(
                        modifier = Modifier.size(25.sdp),
                        img = R.drawable.ic_dashboard_home
                    )
                    TaskBarIcon(
                        modifier = Modifier
                            .padding(end = 20.sdp)
                            .size(25.sdp),
                        img = R.drawable.ic_dashboard_clender
                    )
                    TaskBarIcon(
                        modifier = Modifier
                            .padding(start = 20.sdp)
                            .size(25.sdp),
                        img = R.drawable.ic_dashboard_contact
                    )
                    TaskBarIcon(
                        modifier = Modifier
                            .size(25.sdp),
                        img = R.drawable.ic_dashboard_settings_gare
                    )
                }

            }
        }
    }
}

