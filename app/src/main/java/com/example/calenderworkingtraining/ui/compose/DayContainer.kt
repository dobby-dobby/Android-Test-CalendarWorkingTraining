package com.example.calenderworkingtraining.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.calenderworkingtraining.model.WorkoutDay

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