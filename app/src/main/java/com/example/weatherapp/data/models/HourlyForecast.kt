package com.example.weatherapp.data.models

import androidx.annotation.DrawableRes

data class HourlyForecast(
    val descriptor: String,
    @DrawableRes val icon : Int,
    val hour:String,
    val temperature: String
)