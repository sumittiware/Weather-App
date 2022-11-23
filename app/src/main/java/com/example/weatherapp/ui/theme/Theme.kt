package com.example.weatherapp.ui.theme

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import androidx.lifecycle.viewmodel.compose.viewModel

@SuppressLint("ConflictingOnColor")
private val DarkColorScheme = darkColors(
    primary = DarkGray,
    secondary = BlueDark,
    surface = Gray,
    onSurface = BlueDark,
    onPrimary = Color.White,
)

@SuppressLint("ConflictingOnColor")
private val LightColorScheme = lightColors(
    primary = Color.White,
    secondary = Blue,
    surface = GrayLight,
    onSurface = BlueLight,
    onPrimary = Black,
    onSecondary = Color.White
)

@Composable
fun WeatherAppTheme(

    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
       darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colors = colorScheme,
        typography = Typography,
        content = content
    )
}