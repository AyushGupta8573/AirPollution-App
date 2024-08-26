package com.example.airpollutionapp.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.airpollutionapp.network.WeatherApi
import com.example.airpollutionapp.network.AirResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}

data class WeatherState(
    val result:AirResponse = AirResponse(),
    val status: Status = Status.LOADING,
    val error: String = "",
)

class WeatherViewModel() : ViewModel() {

    private val _state = MutableStateFlow(WeatherState())
    val state = _state.asStateFlow()

    init {
        getWeatherData()
    }

    private fun getWeatherData() {
        viewModelScope.launch {
            try {
                val result = WeatherApi.retrofitService.getWeather(
                    city = "Kanpur",
                    apiKey = "a7cd198c020bb86e19ee90789e199908"
                )
                _state.update { it.copy(result = result, status = Status.SUCCESS) }
            } catch (e: Exception) {
                _state.update {
                    it.copy(status = Status.ERROR, error = e.message?:"Something went wrong")
                }
            }
        }
    }
}