package com.example.airpollutionapp.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.airpollutionapp.network.AirApi
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

class AirViewModel() : ViewModel() {

    private val _state = MutableStateFlow(WeatherState())
    val state = _state.asStateFlow()

    init {
        getAirData()
    }

    private fun getAirData() {
        viewModelScope.launch {
            try {
                val value = AirApi.retrofitService.getAirPoll(
                    lat = 26.50,
                    lon = 80.80,
                    apiKey = "a7cd198c020bb86e19ee90789e199908"
                )
                _state.update { it.copy(result = value, status = Status.SUCCESS) }
            } catch (e: Exception) {
                _state.update {
                    it.copy(status = Status.ERROR, error = e.message?:"Something went wrong")
                }
            }
        }
    }
}