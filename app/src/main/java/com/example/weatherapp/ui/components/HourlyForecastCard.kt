package com.example.weatherapp.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.data.models.HourlyForecast
import com.example.weatherapp.ui.theme.WeatherAppTheme


@Composable
fun HourlyForecastCard(
    hourlyForecast: HourlyForecast,
    modifier : Modifier = Modifier
) = Card(
    modifier = modifier,
    shape = RoundedCornerShape(12.dp),
    elevation = 4.dp,
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Icon(
            painter = painterResource(id = hourlyForecast.icon),
            contentDescription = hourlyForecast.descriptor,
            modifier = Modifier.size(36.dp),
            tint = Color.Unspecified
        )
        Text(
            text = hourlyForecast.hour,
            style = MaterialTheme.typography.body2
        )
        Text(
            text = hourlyForecast.temperature,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview
@Composable
fun HourlyForcastCardPreview() {
    WeatherAppTheme(darkTheme = true) {
        HourlyForecastCard(hourlyForecast =  HourlyForecast(
            descriptor = "Cloudy",
            icon = R.drawable.cloud,
            hour = "19:00",
            temperature = "20"
        ))
    }
}

