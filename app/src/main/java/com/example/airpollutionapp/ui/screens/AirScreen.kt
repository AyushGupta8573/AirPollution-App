package com.example.airpollutionapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.airpollutionapp.network.Components

@Composable
fun AirScreen(
    modifier: Modifier = Modifier,
    state: WeatherState,
    onRefresh: () -> Unit,
) {
    var isOpen: Boolean by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Air Pollution Application",
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Blue,
                fontWeight = FontWeight.ExtraBold,
                modifier = modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }

        Spacer(modifier = modifier.padding(20.dp))

        Button(
            onClick = { isOpen = !isOpen },
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text(
                text = "Click Here",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.ExtraBold,
            )
        }
        if (isOpen) {
            Column {
                Text(text = "${state.result.coord}")
                Text(text = "${state.result.list}")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun AirScreenPreview() {
    AirScreen(state = WeatherState(),
        onRefresh = {})
}
