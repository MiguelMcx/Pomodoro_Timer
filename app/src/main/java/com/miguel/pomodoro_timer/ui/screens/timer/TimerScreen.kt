package com.miguel.pomodoro_timer.ui.screens.timer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.approachLayout
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
    fun CuentaAtras(
        viewModel: TimerViewModel = viewModel(),
        modifier: Modifier = Modifier
    ) {
        val value = viewModel.currentTime / viewModel.TiempoTotal.toFloat()


        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier.fillMaxSize()

        ) {
            Text(
                text = (viewModel.currentTime/1000L).toString(),
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Row(
                modifier = Modifier
                    .align ( Alignment.BottomCenter )
                    .padding(bottom = 50.dp),
                    verticalAlignment =  Alignment.CenterVertically
            ) {
                Button(
                onClick = {
                    if (viewModel.isTimerRunning){
                        viewModel.pauseTimer()
                    } else {
                        viewModel.startTimer()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                        if (viewModel.isTimerRunning) {
                            Color.Green
                        } else {
                            Color.Red
                        }
                )
            ) {
                Text(text = if(viewModel.isTimerRunning)"Fin"
                else if (viewModel.currentTime < viewModel.TiempoTotal) "Empezar"
                else "Reiniciar"
                )

            }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {viewModel.longButtomTime()},
                ) {
                    Text(text = "Contador Largo")
                }
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {viewModel.smallButtonTime()},
                ) {
                    Text(text = "Contador Corto")
                }
            }

        }
    }
