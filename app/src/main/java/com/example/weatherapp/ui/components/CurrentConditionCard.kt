package com.example.weatherapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.data.models.CurrentCondition
import com.example.weatherapp.ui.theme.WeatherAppTheme



@Composable
fun CurrentConditionCard(
    currentCondition : CurrentCondition,
    modifier: Modifier = Modifier
) = Card(
    modifier = modifier,
    shape = RoundedCornerShape(12.dp),
    elevation = 4.dp,
    backgroundColor = MaterialTheme.colors.primary
) {
    Column(
        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = currentCondition.conditionTitle)
        Text(text = currentCondition.conditionValue)
    }
}


@Composable
fun CurrentConditionRow(
    currentConditions: List<CurrentCondition>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
    ) {
        currentConditions.forEach { condition ->
            CurrentConditionCard(
                currentCondition = condition,
                Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun CurrentConditionPreview() {
    WeatherAppTheme(darkTheme = true) {
        CurrentConditionCard(currentCondition =  CurrentCondition("Wind","234"),)
    }
}

@Preview
@Composable
fun CurrentConditionRowPreview() {
    WeatherAppTheme(darkTheme = true) {
        CurrentConditionRow(currentConditions = listOf<CurrentCondition>(
            CurrentCondition("Wind","234"),
            CurrentCondition("Temp","16"),
            CurrentCondition("Humidity","23%")
        ),)
    }
}