package com.example.weatherapp.data.models

import androidx.annotation.DrawableRes

data class CurrentWeather(
    val location: String,
    val date: String,
    @DrawableRes val weatherIcon:Int,
    val weatherDescription: String
)
