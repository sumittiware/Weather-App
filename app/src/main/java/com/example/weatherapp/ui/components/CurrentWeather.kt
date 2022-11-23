package com.example.weatherapp.ui.components

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.R
import com.example.weatherapp.data.models.CurrentWeather
import com.example.weatherapp.ui.theme.DarkGray
import com.example.weatherapp.ui.theme.WeatherAppTheme


@Composable
fun CurrentWeatherField(
    currentWeather: CurrentWeather,
    modifier: Modifier = Modifier
)  = Column(
    modifier = modifier.padding(16.dp)
    ){
        val textColor = if(isSystemInDarkTheme()) Color.White else Color.Black
        CompositionLocalProvider(LocalContentColor provides textColor) {
            Text(
                text = currentWeather.location,
                style = MaterialTheme.typography.h5.copy(
                    fontWeight = FontWeight.Medium
                )
            )
            Text(
                text = currentWeather.date,
                style = MaterialTheme.typography.subtitle2.copy(
                    fontWeight = FontWeight.Normal
                )
            )
            Icon(
                painter = painterResource(id = currentWeather.weatherIcon),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Text(
                text = currentWeather.weatherDescription,
                style = MaterialTheme.typography.h4.copy(
                    fontWeight = FontWeight.Medium
                ),
                textAlign = TextAlign.Center,
                modifier =  modifier.fillMaxWidth()
            )
        }
    }


@Preview
@Composable
fun CurrentWeatherpreview() {
    WeatherAppTheme(darkTheme = true) {
        CurrentWeatherField(currentWeather = CurrentWeather(
            "Pulgaon, Maharashtra",
            "Today, 11 November",
            R.drawable.cloud_sunny,
            "Sunny"
        ),)
    }
}
