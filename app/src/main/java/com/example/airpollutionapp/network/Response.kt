package com.example.airpollutionapp.network

import com.google.gson.annotations.SerializedName

data class AirResponse(
    @SerializedName("coord" ) var coord : ArrayList<Int>  = arrayListOf(),
    @SerializedName("list"  ) var list  : ArrayList<List> = arrayListOf()
)

data class Main (

    @SerializedName("aqi" ) var aqi : Int? = null

)

data class Components (

    @SerializedName("co"    ) var co   : Double? = null,
    @SerializedName("no"    ) var no   : Double? = null,
    @SerializedName("no2"   ) var no2  : Double? = null,
    @SerializedName("o3"    ) var o3   : Double? = null,
    @SerializedName("so2"   ) var so2  : Double? = null,
    @SerializedName("pm2_5" ) var pm25 : Double? = null,
    @SerializedName("pm10"  ) var pm10 : Double? = null,
    @SerializedName("nh3"   ) var nh3  : Double? = null

)

data class List (

    @SerializedName("dt"         ) var dt         : Int?        = null,
    @SerializedName("main"       ) var main       : Main?       = Main(),
    @SerializedName("components" ) var components : Components? = Components()

)
