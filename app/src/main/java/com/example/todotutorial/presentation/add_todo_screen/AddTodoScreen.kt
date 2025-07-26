package com.example.todotutorial.presentation.add_todo_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.todotutorial.R
import com.example.todotutorial.presentation.component.comman.TopBar
import com.example.todotutorial.ui.theme.MyColors
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun AddTodoScreen(navigateBack: () -> Unit) {
    var priorityList = listOf("Low", "Medium", "High")

    var isExpanded by remember { mutableStateOf(false) }

    var TaskNameState by remember { mutableStateOf("") }

    var TaskDescription by remember { mutableStateOf("") }

    var PriorityState by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopBar(navigateBack = { navigateBack() }, text = R.string.add_task)
        },
        containerColor = Color.White
    ) {padding->12.sdp

        Column(modifier = Modifier.padding()) {
            Column(
                modifier = Modifier
                    .weight(0.4f)
                    .padding(bottom = 20.sdp)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.7f)
                        .shadow(
                            elevation = 6.sdp,
                            shape = RoundedCornerShape(bottomEnd = 50.sdp, bottomStart = 50.sdp)
                        )
                        .background(
                            MyColors.orangeF34,
                            shape = RoundedCornerShape(bottomStart = 50.sdp, bottomEnd = 50.sdp)
                        )
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {

                        Text(
                            modifier = Modifier
                                .padding(vertical = 35.sdp)
                                .fillMaxWidth(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.ssp,
                            textAlign = TextAlign.Center,
                            text = stringResource(R.string.add_new_task),
                            color = Color.White
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(modifier = Modifier.weight(0.55f)) {

                    TextField(
                        placeholder = { Text(text = stringResource(R.string.task_name)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 25.sdp)
                            .border(
                                width = 2.sdp,
                                color = MyColors.orangeF34,
                                shape = RoundedCornerShape(10.sdp)
                            ),
                        colors = TextFieldDefaults.colors(
                            unfocusedIndicatorColor = Color.White,
                            focusedIndicatorColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        ), value = TaskNameState, onValueChange = {
                            TaskNameState = it
                        })
                }
                Column(modifier = Modifier.weight(1f)) {
                    TextField(
                        placeholder = { Text(text = stringResource(R.string.description)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.sdp)
                            .padding(horizontal = 25.sdp)
                            .border(
                                width = 2.sdp,
                                color = MyColors.orangeF34,
                                shape = RoundedCornerShape(10.sdp)
                            ),
                        colors = TextFieldDefaults.colors(
                            unfocusedIndicatorColor = Color.White,
                            focusedIndicatorColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        ), value = TaskDescription, onValueChange = {
                            TaskDescription = it
                        })
                }
                Column(modifier = Modifier.weight(0.5f)) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.sdp)
                            .padding(horizontal = 25.sdp)
                            .border(
                                width = 2.sdp,
                                color = MyColors.orangeF34,
                                shape = RoundedCornerShape(10.sdp)
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 20.sdp), text = stringResource(R.string.priority)
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .weight(0.45f)
                                .clickable { isExpanded = !isExpanded }) {
                            Text(color = Color.Black,
                                modifier = Modifier.padding(end = 7.sdp),
                                text = if(PriorityState.isEmpty()) {
                                    priorityList[0]
                            } else {
                                PriorityState
                            })
                            Icon(
                                tint = MyColors.orangeF34,
                                painter = painterResource(R.drawable.ic_addnote_dropdown),
                                contentDescription = null
                            )
                            DropdownMenu(
                                containerColor = Color.White ,
                                expanded = isExpanded,
                                onDismissRequest = { isExpanded = false }) {
                                priorityList.map { item ->
                                    DropdownMenuItem(colors = MenuDefaults.itemColors(MyColors.orangeF34),  modifier = Modifier
                                        .padding(top = 2.sdp)
                                        .border(width = 2.sdp, color = MyColors.orangeF34), text = { Text(text = item) }, onClick = {
                                        PriorityState = item
                                        isExpanded=false
                                    })
                                }
                            }
                        }
                    }
                }
                Column(modifier = Modifier.weight(1f)) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.sdp)
                            .padding(horizontal = 25.sdp)
                            .border(
                                width = 2.sdp,
                                color = MyColors.orangeF34,
                                shape = RoundedCornerShape(10.sdp)
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier.padding(horizontal = 20.sdp),
                            painter = painterResource(R.drawable.ic_addnote_calender),
                            contentDescription = null
                        )
                        Text(text = "Due Date")
                    }

                }



                Column(modifier = Modifier.weight(1f)) {

                    Box(
                        modifier = Modifier
                            .size(75.sdp)
                            .shadow(elevation = 6.sdp, shape = RoundedCornerShape(50.sdp))
                            .background(color = MyColors.orangeF34, shape = RoundedCornerShape(50.sdp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            modifier = Modifier.size(33.sdp),
                            painter = painterResource(R.drawable.ic_dashboard_plus),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}
