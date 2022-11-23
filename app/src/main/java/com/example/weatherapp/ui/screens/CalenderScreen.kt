package com.example.weatherapp.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.R
import com.example.weatherapp.data.models.DateForecast
import com.example.weatherapp.ui.components.CalenderView
import com.example.weatherapp.ui.theme.DarkGray
import com.example.weatherapp.ui.theme.GrayLight
import com.example.weatherapp.ui.theme.LightBlack
import com.example.weatherapp.ui.theme.WeatherAppTheme
import java.time.Month

@RequiresApi(Build.VERSION_CODES.O)

@Composable
fun CalenderScreen(
    modifier: Modifier  = Modifier
)  = Scaffold(
    modifier = modifier
) {
    val months = listOf(
        com.example.weatherapp.data.models.Month(
            title = "July",
            dateForecast = List(Month.JULY.length(false)) {
                DateForecast(
                    date = "${it + 1}",
                    icon = R.drawable.sunny,
                    temperature = "27",
                    isToday = (it + 1) == 12
                )
            },
            startDay = 4,
        ),
        com.example.weatherapp.data.models.Month(
            title = "August",
            dateForecast = List(Month.AUGUST.length(false)) {
                DateForecast(
                    date = "${it + 1}",
                    icon = R.drawable.rain,
                    temperature = "27",
                    isToday = false
                )
            },
            startDay = 1,
        ),
    );
    val colors = if(true){
        listOf(
            DarkGray,
            LightBlack
        )
    }else {
        listOf(
            Color.White,
            GrayLight
        )
    }

    CalenderView(months = months)
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun Calenderpreview() {
    WeatherAppTheme(darkTheme = true) {
      CalenderScreen()
    }
}