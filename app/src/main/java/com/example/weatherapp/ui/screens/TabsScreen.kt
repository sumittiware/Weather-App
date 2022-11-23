

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.components.BottomNavigator
import com.example.weatherapp.ui.components.NavigationGraph

@Preview
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TabsScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigator(navController) }
    ) {
        NavigationGraph(navController = navController)
    }
}