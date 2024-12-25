package com.example.calenderworkingtraining.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.calenderworkingtraining.model.WorkoutDay
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun DayContainer(
    workoutDay: WorkoutDay,
    onWorkoutToggle: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {

        workoutDay.assignments.forEach { assignment ->
            WorkoutItem(
                workout = assignment,
                onWorkoutToggle = onWorkoutToggle
            )
        }
    }
}