//package com.example.todotutorial.presentation.LanguageScreen
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Icon
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.SearchBar
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import com.example.todotutorial.R
//import com.example.todotutorial.ui.theme.MyColors
//import ir.kaaveh.sdpcompose.sdp
//import ir.kaaveh.sdpcompose.ssp
//
//@Composable
//fun LanguageScreen(){
//    var searchQuery by remember { mutableStateOf("") }
//    Column(modifier = Modifier
//        .padding(top = 30.sdp)
//        .padding(horizontal = 15.sdp)) {
//        Row(modifier = Modifier
//            //.fillMaxWidth()
//            .height(20.sdp)) {
//
//        Image(painter = painterResource(R.drawable.ic_black_arrow),
//        contentDescription = null,
//        modifier = Modifier
//            .width(18.sdp)
//            .height(13.sdp)
//            .align(Alignment.CenterVertically))
//        Text(text = stringResource(R.string.select_languauges),
//            fontSize = 18.ssp,
//            modifier = Modifier.padding(start = 5.sdp))
//           Spacer(modifier = Modifier.weight(1f))
//            Row(
//                modifier = Modifier.align(Alignment.CenterVertically)
//            ) {
//
//            Text(
//                color = MyColors.orangeF34,
//                text = stringResource(R.string.apply),
//                fontSize = 14.ssp)
//               Image(contentDescription = null,
//                   painter = painterResource(R.drawable.ic_dashboard_checkmark),
//                   modifier = Modifier.padding(start = 5.sdp))
//           }
//            SearchBar (
//                query = searchQuery,
//                onQueryChange = { searchQuery = it }
//            )
//        }
//
//
//
//        @Composable
//        fun SearchBar(
//            query: String,
//            onQueryChange: (String) -> Unit,
//            placeholderText: String = "Search by Country"
//        ) {
//            OutlinedTextField(
//                value = query,
//                onValueChange = onQueryChange,
//                leadingIcon = {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_search),
//                        contentDescription = null
//                    )
//                },
//                placeholder = {
//                    Text(text = placeholderText)
//                },
//                singleLine = true,
//                shape = RoundedCornerShape(12.sdp),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 10.sdp),
//            )
//        }
//
//    }
//}


package com.example.todotutorial.presentation.LanguageScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.todotutorial.R
import com.example.todotutorial.ui.theme.MyColors
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun LanguageScreen() {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 30.sdp)
            .padding(horizontal = 15.sdp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.sdp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.ic_black_arrow),
                contentDescription = null,
                modifier = Modifier
                    .width(18.sdp)
                    .height(13.sdp)
            )

            Text(
                text = stringResource(R.string.select_languauges),
                fontSize = 18.ssp,
                modifier = Modifier.padding(start = 5.sdp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    color = MyColors.orangeF34,
                    text = stringResource(R.string.apply),
                    fontSize = 14.ssp
                )
                Image(
                    contentDescription = null,
                    painter = painterResource(R.drawable.ic_dashboard_checkmark),
                    modifier = Modifier.padding(start = 5.sdp)
                )
            }
        }

              SearchBar(
            query = searchQuery,
            onQueryChange = { searchQuery = it }
        )

        Card(

            colors = CardDefaults.cardColors(Color.White),
            shape = RoundedCornerShape(12.sdp),
            elevation = CardDefaults.cardElevation(2.sdp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.sdp)
        ) {

            Row(
                modifier = Modifier
                    .padding(10.sdp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_eng),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 10.sdp)
                        .align(Alignment.CenterVertically)
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = stringResource(R.string.english_uk),
                        fontSize = 14.ssp,
                        color = Color.Black
                    )
                    Text(
                        text = stringResource(R.string.phone_default),
                        fontSize = 12.ssp,
                        color = MyColors.greyD56_80
                    )
                }

            }
        }

    }
}

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    placeholderText: String = "Search by Country"
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null
            )
        },
        placeholder = {
            Text(text = placeholderText)
        },
        singleLine = true,
        shape = RoundedCornerShape(12.sdp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.sdp)
    )
}
