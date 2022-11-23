package com.example.weatherapp.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.example.weatherapp.R
import androidx.compose.ui.Modifier
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.data.models.Screen
import com.example.weatherapp.ui.theme.WeatherAppTheme

val screens = listOf(
    Screen.Home,
    Screen.Calender,
)

@Composable
fun BottomNavigator(
    navController: NavController,
    modifier: Modifier = Modifier
) = BottomNavigation(modifier) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    screens.forEach { screen ->
    CompositionLocalProvider(LocalContentColor provides MaterialTheme.colors.onSurface) {
        BottomNavigationItem(
            selected = screen.route == currentRoute,
            onClick = {
                navController.navigate(screen.route) {
                    navController.graph.startDestinationRoute?.let { screen_route ->
                        popUpTo(screen_route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = screen.iconRes),
                    contentDescription = null
                )
            },
           label = {
               Text(stringResource(id = screen.stringRes))
           },
            alwaysShowLabel = false
        )
    }
}
}

@Preview
@Composable
fun BottomBarPreview() {
    WeatherAppTheme(darkTheme = true) {
        BottomNavigator(navController = rememberNavController())
    }
}