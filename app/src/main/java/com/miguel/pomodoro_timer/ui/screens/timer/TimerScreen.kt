package com.miguel.pomodoro_timer.ui.screens.timer


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun CuentaAtras(

    viewModel: TimerViewModel = viewModel(), modifier: Modifier = Modifier

) {

    //val value = viewModel.currentTime / viewModel.TiempoTotal.toFloat()

    val totalSeconds = viewModel.currentTime / 1000
    val minutes = totalSeconds / 60
    val reamainingSeconds = totalSeconds % 60


    val formattedTime = String.format("%02d:%02d", minutes, reamainingSeconds)



    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFF6961))

    ) {
        Column {
            Text(
                text = formattedTime,
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

        }



        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 140.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {


            if (!viewModel.isTimerRunning) {
                Spacer(modifier = Modifier.width(16.dp))

                OutlinedButton(
                    onClick = { viewModel.ResetTimer() },
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)

                ) {

                    Text(text = "Reset")
                }

                Spacer(modifier = Modifier.width(16.dp))
                OutlinedButton(
                    onClick = { viewModel.longButtomTime() },
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),

                    ) {
                    Text(text = "Contador Largo")
                }
                Spacer(modifier = Modifier.width(16.dp))

                OutlinedButton(
                    onClick = { viewModel.smallButtonTime() },
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),

                    ) {
                    Text(text = "Contador Corto")
                }
            }
        }
        Button(
            onClick = {
                if (viewModel.isTimerRunning) {
                    viewModel.pauseTimer()
                } else {
                    viewModel.startTimer()
                }
            },
            modifier = Modifier
                .align (Alignment.BottomCenter)
                .padding(bottom = 50.dp)
                .fillMaxWidth(0.6f)
                .height(60.dp),
             colors = ButtonDefaults.buttonColors(
                Color.White, Color.Red
            )

        ) {
            Text(
                text = if (viewModel.isTimerRunning) "Fin"
                else "Empezar"
            )
        }

    }

}
