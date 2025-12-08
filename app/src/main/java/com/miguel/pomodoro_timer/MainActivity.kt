package com.miguel.pomodoro_timer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miguel.pomodoro_timer.ui.theme.Pomodoro_TimerTheme
import com.miguel.pomodoro_timer.ui.screens.timer.CuentaAtras

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pomodoro_TimerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    CuentaAtras(


    )
                }
            }
        }
    }
}



@Preview
@Composable

fun PomodoroPreview (){
    Pomodoro_TimerTheme() {
        CuentaAtras()
    }
}
