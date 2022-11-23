package com.example.weatherapp.data.models


data class Month(
    val title: String,
    val startDay : Int,
    val dateForecast: List<DateForecast>
)