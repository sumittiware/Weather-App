package com.example.weatherapp.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.weatherapp.R

sealed class Screen (
    val route : String,
    @StringRes val stringRes:Int,
    @DrawableRes val iconRes :Int
) {
    object Home : Screen("Home", R.string.nav_home, R.drawable.ic_round_home)
    object Calender : Screen("Calender", R.string.nav_calender, R.drawable.ic_round_calendar_today_24)
}