package com.miguel.pomodoro_timer.ui.screens.timer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class TimerViewModel : ViewModel(){
    var TiempoTotal: Long = 25 * 60 * 1000L



    var currentTime by mutableStateOf(TiempoTotal)
        private set

    var isTimerRunning by mutableStateOf(false)
        private set

    private var timerJob: Job? = null

    fun startTimer(){
        isTimerRunning = true

        timerJob=viewModelScope.launch {
            while (currentTime > 0){
                delay(100L)
                currentTime -= 100L
            }
            isTimerRunning = false
        }
    }

    fun pauseTimer(){
        isTimerRunning = false
        timerJob?.cancel()
    }

    fun ResetTimer(){
        isTimerRunning = false
        timerJob?.cancel()
        currentTime = TiempoTotal
    }

    fun longButtomTime(){
        currentTime = 25 * 60 * 1000L
    }

    fun smallButtonTime(){
        currentTime = 5*60*1000L
    }
}