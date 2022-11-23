package com.example.weatherapp.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.data.models.DateForecast
import com.example.weatherapp.data.models.Month
import com.example.weatherapp.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MonthLabel(
     month : String,
     modifier: Modifier = Modifier,

) {
    val weekdays = listOf(
        DayOfWeek.SUNDAY,
        DayOfWeek.MONDAY,
        DayOfWeek.TUESDAY,
        DayOfWeek.WEDNESDAY,
        DayOfWeek.THURSDAY,
        DayOfWeek.FRIDAY,
        DayOfWeek.SATURDAY
    ).map {
        it.getDisplayName(TextStyle.SHORT, Locale.getDefault())
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.surface),
    ) {
        Text(
            text = month,
            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.SemiBold),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onPrimary
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            weekdays.forEach { it->
                Text(
                    text = it,
                    modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
}

@Composable
fun DateForecastCard(
    dateForecast: DateForecast,
    modifier: Modifier = Modifier
) = Card(
    modifier = modifier,
    shape = RoundedCornerShape(12.dp),
    elevation = 4.dp,
    backgroundColor = if(dateForecast.isToday) Blue else MaterialTheme.colors.surface
) {

    Column(
        modifier.padding(8.dp),
        horizontalAlignment  = Alignment.CenterHorizontally
    ) {
        Text(
            text = dateForecast.date,
            style = MaterialTheme.typography.caption,
            color =  if(!dateForecast.isToday) Blue else Color.White
        )
        Icon(
            painter = painterResource(id = dateForecast.icon),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .size(24.dp)
        )
        Text(
            text = dateForecast.temperature,
            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.SemiBold),
            color =  if(!dateForecast.isToday) Blue else Color.White
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun CalenderView(
    months : List<Month>,
    modifier: Modifier = Modifier
) {
    val pageState = rememberPagerState();
    val gridCellNumber = 7
    VerticalPager(
        count = months.size,
        state = pageState,
        modifier = modifier.fillMaxSize()
        ) { index ->
        val month = months[index]
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            MonthLabel(month = months[index].title)
            LazyVerticalGrid(
                modifier = modifier.padding(vertical = 8.dp, horizontal = 8.dp),
                cells = GridCells.Fixed(gridCellNumber),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                items(month.startDay) {
                    BlankCard()
                }
                items(month.dateForecast) {
                    DateForecastCard(dateForecast = it)
                }
            }
        }
    }
}

@Composable
fun BlankCard(
    modifier: Modifier = Modifier
) {
    Column{}
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun MonthLabelPreview() {
    WeatherAppTheme(darkTheme = true) {
        MonthLabel(month = "November")
    }
}

@Preview
@Composable
fun DateForcastPreview() {
    WeatherAppTheme(darkTheme = true) {
        DateForecastCard(dateForecast = DateForecast(
            date = "1",
            icon = R.drawable.rain,
            temperature = "27",
            isToday = true
        ))
    }
}