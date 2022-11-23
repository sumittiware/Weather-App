package com.example.weatherapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.R
import com.example.weatherapp.data.models.CurrentCondition
import com.example.weatherapp.data.models.CurrentWeather
import com.example.weatherapp.data.models.HourlyForecast
import com.example.weatherapp.ui.components.*
import com.example.weatherapp.ui.theme.DarkGray
import com.example.weatherapp.ui.theme.GrayLight
import com.example.weatherapp.ui.theme.LightBlack
import com.example.weatherapp.ui.theme.WeatherAppTheme

data class HomeScreenState(
    val currentWeather: CurrentWeather,
    val currentCondition: List<CurrentCondition>,
    val hourlyForecast: List<HourlyForecast>
)
@Composable
fun HomeScreen(

    modifier: Modifier = Modifier
) {
    val state = HomeScreenState(
        CurrentWeather(
            "Pulgaon, Maharashtra",
            "Today, 11 November",
            R.drawable.cloud_sunny,
            "Sunny"
        ),
        listOf<CurrentCondition>(
            CurrentCondition("Wind","234"),
            CurrentCondition("Temp","16"),
            CurrentCondition("Humidity","23%")
        ),
        List(7) {
            HourlyForecast(
                descriptor = "Cloudy",
                icon = R.drawable.cloud,
                hour = "19:00",
                temperature = "20"
            )
        }
    )
    val colors = if(true){
        listOf(
            DarkGray,
            LightBlack
        )
    }else{
        listOf(
            Color.White,
            GrayLight
        )
    }
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(Brush.linearGradient(colors))
        ) {
            CurrentWeatherField(currentWeather = state.currentWeather)
            CurrentConditionRow(currentConditions = state.currentCondition,Modifier.padding(bottom = 16.dp))
           HourlyForecastSheet(hourlyForecast = state.hourlyForecast)
        }

}

@Preview
@Composable
fun HomePreview() {
    WeatherAppTheme(darkTheme = true) {
        HomeScreen()
    }
}