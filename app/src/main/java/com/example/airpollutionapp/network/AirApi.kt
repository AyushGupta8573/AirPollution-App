package com.example.airpollutionapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val baseUrl = "http://api.openweathermap.org/data/2.5/";

private val retrofit = Retrofit.Builder()
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface WeatherApiService {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
    ): AirResponse
}

object WeatherApi {
    val retrofitService: WeatherApiService by lazy {
        retrofit.create(WeatherApiService::class.java)
    }
}

/*interface AirApi {
      @Query("key") city: String,
        @Query("q") apikey: String,
    ): AirResponse
}

object AirApiService {
    val retrofitService: AirApiService by lazy {
        retrofit.create(AirApiService::class.java)
    }
}*/