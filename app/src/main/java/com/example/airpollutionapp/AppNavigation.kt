package com.example.airpollutionapp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.airpollutionapp.ui.screens.AirScreen
import com.example.airpollutionapp.ui.screens.WeatherViewModel
import java.lang.reflect.Modifier

enum class Screen(val route: String) {
    Home("home"),
    Setting("settings")
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val vm: WeatherViewModel = viewModel()
    val nc = rememberNavController()

    NavHost(navController = nc, startDestination = Screen.Home.route) {
        composable(Screen.Home.route){
            AirScreen(
                modifier = modifier,
                state = vm.state.collectAsState().value
            ){
                nc.navigate(Screen.Setting.route)
            }
        }
        composable(Screen.Setting.route){
            Text("Settings not available")
        }
    }
}