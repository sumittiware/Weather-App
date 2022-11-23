package com.example.weatherapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.data.models.HourlyForecast
import com.example.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun HourlyForecastSheet(
    hourlyForecast: List<HourlyForecast>,
    modifier: Modifier = Modifier
) = Card(
    modifier = modifier.fillMaxWidth(),
    shape = RoundedCornerShape(
        topStart = CornerSize(16.dp),
        topEnd = CornerSize(16.dp),
        bottomEnd = CornerSize(0.dp),
        bottomStart = CornerSize(0.dp)
    ),
    backgroundColor = MaterialTheme.colors.primary
) {
    Column(modifier = Modifier.padding(
        top = 16.dp,
        bottom = 32.dp
    ),) {
        TopRow()
        LazyRow(

            horizontalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(4.dp)
        ) {
            items(hourlyForecast) { forecast ->
                HourlyForecastCard(hourlyForecast = forecast)
            } 
        }
    }
}

@Composable
private fun TopRow(modifier: Modifier = Modifier) = Row(
    modifier = modifier
        .fillMaxWidth()
        .padding(
            start = 16.dp,
            end = 16.dp
        ),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
) {
    Text(text = stringResource(id = R.string.today))
    Text(text = stringResource(id = R.string.next_7_days))
}


@Preview
@Composable
fun HourlyForcastPreview() {
    WeatherAppTheme(darkTheme = true)  {
        HourlyForecastSheet(hourlyForecast =  List(7) {
            HourlyForecast(
                descriptor = "Cloudy",
                icon = R.drawable.cloud,
                hour = "19:00",
                temperature = "20"
            )
        })
    }
}