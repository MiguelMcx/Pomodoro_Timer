package com.miguel.pomodoro_timer

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miguel.pomodoro_timer.ui.theme.Pomodoro_TimerTheme
import kotlinx.coroutines.delay
import java.security.Key

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pomodoro_TimerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    CuentaAtras(
        totalTime = 100L*1000L,
        handlecolor = Color.Green,
        inactiveBarColor = Color.DarkGray,
        activeBarColor = Color.LightGray,
        modifier = Modifier.size(200.dp)

    )
                }
            }
        }
    }
}

@Composable
fun CuentaAtras(
    totalTime: Long,
    handlecolor: Color,
    inactiveBarColor: Color,
    activeBarColor: Color,
    modifier: Modifier = Modifier,
    initialValue: Float = 1f,
    strokeWidth: Dp = 5.dp

) {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }

    var value by remember {
        mutableStateOf(initialValue)

    }
    var currentTime by remember {
        mutableStateOf(totalTime)
    }
    var isTimerRunning by remember{
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = currentTime , isTimerRunning) {
        if (currentTime > 0 && isTimerRunning){
            delay(100L)
            currentTime -= 100L
            value = currentTime / totalTime.toFloat()
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .onSizeChanged{
                size = it
}
    ) {
        Text(
            text = (currentTime / 1000L).toString(),
            fontSize = 44.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Button(
            onClick = {
                if (currentTime <= 0L){
                    currentTime = totalTime
                    isTimerRunning = true
                } else {
                    isTimerRunning = !isTimerRunning
                }
            },
            modifier = Modifier.align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(
                containerColor =
                    if (!isTimerRunning || currentTime <= 0L) {
                        Color.Green
                    } else {
                        Color.Red
                    }
            )
        ) {
Text(text = if(isTimerRunning && currentTime >= 0L)"Fin"
            else if (!isTimerRunning && currentTime >= 0L) "Empizar"
            else "Reiniciar"
    )
        }
    }
}