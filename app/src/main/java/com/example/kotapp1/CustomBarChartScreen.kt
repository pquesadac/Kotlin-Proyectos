package com.example.kotapp1


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class BarData(
    val value: Float,
    val label: String,
    val color: Color
)

@Composable
fun CustomBarChartScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Gráfica Personalizada",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        TextButton(onClick = { navController.navigate("MainActivity") }) {
            Text("Volver a inicio")
        }

        val barData = listOf(
            BarData(
                value = 5f,
                label = "Motos",
                color = Color(0xFF4CAF50)
            ),
            BarData(
                value = 4f,
                label = "Coches",
                color = Color(0xFF2196F3)
            ),
            BarData(
                value = 8f,
                label = "Camiones",
                color = Color(0xFFFFC107)
            ),

        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(310.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Vehículos en Taller",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                CustomBarChart(
                    barData = barData,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    barData.forEach { bar ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .background(bar.color, RoundedCornerShape(2.dp))
                            )
                            Spacer(modifier = Modifier.width(4.dp))
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

@Composable
fun CustomBarChart(
    barData: List<BarData>,
    modifier: Modifier = Modifier
) {
    val textMeasurer = rememberTextMeasurer()

    val maxValue = barData.maxOfOrNull { it.value } ?: 1f

    Canvas(modifier = modifier) {
        val cWidth = size.width
        val cHeight = size.height

        drawLine(
            color = Color.Gray,
            start = Offset(40f, 20f),
            end = Offset(40f, cHeight - 40f),
            strokeWidth = 2f
        )

        drawLine(
            color = Color.Gray,
            start = Offset(40f, cHeight - 40f),
            end = Offset(cWidth - 20f, cHeight - 40f),
            strokeWidth = 2f
        )

        val numBars = barData.size
        val barAreaWidth = (cWidth - 60f) / numBars
        val barWidth = barAreaWidth * 0.6f
        val barSpacing = barAreaWidth - barWidth

        barData.forEachIndexed { index, bar ->
            val barHeight = ((cHeight - 60f) * (bar.value / maxValue))

            val barX = 40f + (barAreaWidth * index) + (barSpacing / 2)

            val barY = cHeight - 40f - barHeight

            drawRect(
                color = bar.color,
                topLeft = Offset(barX, barY),
                size = Size(barWidth, barHeight)
            )

            val valueText = bar.value.toInt().toString()
            val textLayoutResult = textMeasurer.measure(
                text = valueText,
                style = TextStyle(fontSize = 12.sp, color = Color.Black)
            )

            drawText(
                textLayoutResult = textLayoutResult,
                topLeft = Offset(
                    barX + (barWidth / 2) - (textLayoutResult.size.width / 2),
                    barY - textLayoutResult.size.height - 4f
                )
            )

            val labelLayoutResult = textMeasurer.measure(
                text = bar.label,
                style = TextStyle(fontSize = 10.sp, color = Color.Black)
            )

            drawText(
                textLayoutResult = labelLayoutResult,
                topLeft = Offset(
                    barX + (barWidth / 2) - (labelLayoutResult.size.width / 2),
                    cHeight - 35f
                )
            )
        }
    }
}