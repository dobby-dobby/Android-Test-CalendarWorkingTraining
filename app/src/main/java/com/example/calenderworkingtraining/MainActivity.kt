package com.example.calenderworkingtraining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.ui.Modifier
import com.example.calenderworkingtraining.ui.WorkoutScheduleScreen
import com.example.calenderworkingtraining.ui.theme.CalenderWorkingTrainingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Box(Modifier.safeDrawingPadding()) {
                CalenderWorkingTrainingTheme {
                    WorkoutScheduleScreen()
                }
            }
        }
    }
}