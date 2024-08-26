package com.example.airpollutionapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val base_Url = "http://api.openweathermap.org/data/3.0/";

private val retrofit = Retrofit.Builder()
    .baseUrl(base_Url)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface AirApiService {
    @GET("Air Pollution")
    suspend fun getAirPoll(
        @Query("q") lat: Double,
        @Query("r") lon: Double,
        @Query("appid") apiKey: String,
    ): AirResponse
}

object AirApi {
    val retrofitService: AirApiService by lazy {
        retrofit.create(AirApiService::class.java)
    }
}
