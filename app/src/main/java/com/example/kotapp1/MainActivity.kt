package com.example.kotapp1


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotapp1.ui.theme.KotApp1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val counterViewModel = viewModel<ContadorViewModel.CounterViewModel>()
            val moviesViewModel = viewModel<MoviesViewModel>()
            val navController = rememberNavController()

            KotApp1Theme {
                NavHost(navController = navController, startDestination = "MainActivity") {
                    composable("screen1") {
                        Screen1(navController, counterViewModel)
                    }
                    composable("MainActivity") {
                        PantallaPrincipal(navController, counterViewModel)
                    }
                    composable("movies") {
                        MoviesScreen(navController, moviesViewModel)
                    }
                    composable("taller_grafica") {
                        TallerGraficaScreen(navController)
                    }
                    composable("custom_chart") {
                        CustomBarChartScreen(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun PantallaPrincipal(navController: NavController, viewModel: ContadorViewModel.CounterViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextButton(onClick = { viewModel.incrementCounter() }) {
            Text("CLICS: ${viewModel.counter}")
        }

        TextButton(onClick = { navController.navigate("screen1") }) {
            Text("Ir a Contador")
        }

        TextButton(onClick = { navController.navigate("movies") }) {
            Text("Ver Películas Populares")
        }

        TextButton(onClick = { navController.navigate("taller_grafica") }) {
            Text("Ir a Gráfica")
        }
        TextButton(onClick = { navController.navigate("custom_chart") }) {
            Text("Gráfica Personalizada")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotApp1Theme {
    }
}