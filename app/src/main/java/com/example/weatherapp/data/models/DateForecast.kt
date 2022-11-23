package com.example.weatherapp.data.models

import androidx.annotation.DrawableRes

data class DateForecast(
    val date : String,
    val temperature : String,
    val isToday :  Boolean,
    @DrawableRes val icon : Int
)