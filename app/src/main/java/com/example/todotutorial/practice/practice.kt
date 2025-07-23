package com.example.todotutorial.practice

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.koinViewModel


@Composable
fun Practice(practiceViewModel: PracticeViewModel= koinViewModel()) {

    val state by practiceViewModel.state.collectAsState()

    var stateLocal by remember { mutableStateOf(state.increamentState) }
//        var state=0

    val context=LocalContext.current
    Column {


        Button(onClick = {
            stateLocal++
            practiceViewModel.IncreamentClick(stateLocal)
        Toast.makeText(context,"${state}", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "increment")
        }


        Text("${state.increamentState}")
    }

}