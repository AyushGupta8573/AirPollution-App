package com.example.airpollutionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.airpollutionapp.ui.screens.AirScreen
import com.example.airpollutionapp.ui.screens.WeatherState
import com.example.airpollutionapp.ui.theme.AirPollutionAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AirPollutionAppTheme {
                    AirScreen(
                        state = WeatherState(),
                        onRefresh = {}
                    )
                }
            }
        }
    }
