package com.example.kotapp1


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.tehras.charts.bar.BarChart
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.renderer.bar.SimpleBarDrawer

@Composable
fun TallerGraficaScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Grafica",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        TextButton(onClick = { navController.navigate("MainActivity") }) {
            Text("Volver a inicio")
        }

        val barData = listOf(
            BarChartData.Bar(
                value = 5f,
                label = "Motos",
                color = Color(0xFF4CAF50)
            ),
            BarChartData.Bar(
                value = 3f,
                label = "Coches",
                color = Color(0xFF2196F3)
            )
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(300.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Cantidad de Vehículos en Taller",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                BarChart(
                    barChartData = BarChartData(bars = barData),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    barDrawer = SimpleBarDrawer()
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    barData.forEach { bar ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(12.dp)
                                    .padding(end = 4.dp)
                                    .background(bar.color)
                            )
                            Text(
                                text = "${bar.label}: ${bar.value.toInt()}",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }
    }
}