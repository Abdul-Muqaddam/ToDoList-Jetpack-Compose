package com.example.todotutorial.presentation.dashboard_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.todotutorial.R
import com.example.todotutorial.data.entity.TaskEntitiy
import com.example.todotutorial.ui.theme.MyColors
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun CurrentTask(
    taskList:TaskEntitiy,
    onCompletedClick:(Boolean)->Unit
) {
    var isChecked by remember { mutableStateOf(taskList.isCompleted) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.sdp)
            .height(50.sdp)
            .padding(horizontal = 25.sdp)
            .border(width = 2.sdp, color = MyColors.orangeF34, shape = RoundedCornerShape(10.sdp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .clickable{
                    isChecked=!isChecked
                    onCompletedClick(isChecked)
                }
                .padding(horizontal = 18.sdp)
                .size(23.sdp),
            painter =
                if(isChecked){
                painterResource(R.drawable.ic_dashboard_checkmark)
                }else{

                painterResource(R.drawable.ic_dashboard_emptycheckmark)
                },
            contentDescription = null
        )
        Text(fontSize = 18.ssp, text = taskList.name)
    }
}