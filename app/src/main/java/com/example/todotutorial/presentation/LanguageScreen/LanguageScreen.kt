
package com.example.todotutorial.presentation.LanguageScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.foundation.lazy.grid.items
import com.example.todotutorial.data.AppPreference
import com.example.todotutorial.ui.theme.MyColors
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp
import org.koin.androidx.compose.koinViewModel

@Composable
fun LanguageScreen(
    onLanguageApplyClicked:()->Unit,
    navigateBckToSettingScreen: () -> Unit,
    viewModel: LanguageScreenViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()

    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
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
                    .clickable { navigateBckToSettingScreen() }
            )

            Text(
                text = stringResource(R.string.select_languauges),
                fontSize = 18.ssp,
                modifier = Modifier.padding(start = 5.sdp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.clickable {
                    onLanguageApplyClicked()
                    AppPreference.setLanguageCode(state.selectedLanguage)
                },
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
            onQueryChange = {
                searchQuery = it
                viewModel.onLanguageSearch(it)
            }
        )


        val selectedLanguage by remember(state) {
            derivedStateOf {
                state.languages.firstOrNull { it.isSelected }
            }
        }

        selectedLanguage?.let { selectLanguage ->


            Card(

                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(12.sdp),
                elevation = CardDefaults.cardElevation(2.sdp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.sdp)
            ) {

                Row(
                    modifier = Modifier
                        .padding(10.sdp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(selectLanguage.img),
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
                            text = selectLanguage.languageName,
                            fontSize = 14.ssp,
                            color = Color.Black
                        )
                        Text(
                            text = selectLanguage.nativeName,
                            fontSize = 12.ssp,
                            color = MyColors.greyD56_80
                        )
                    }

                }
            }
        }

        Text(
            modifier = Modifier.padding(top = 15.sdp, bottom = 15.sdp),
            text = "All Languages",
            color = MyColors.orangeF34,
            fontSize = 15.ssp
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.sdp),
            verticalArrangement = Arrangement.spacedBy(8.sdp)
        ) {
            items(state.languages) { model ->
                LanguageScreenComponent(model = model, languageSelected = {
                    viewModel.onLanguageSelect(it)
                })
            }


        }
    }

}
//}

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
