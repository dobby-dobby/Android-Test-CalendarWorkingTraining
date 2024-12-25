package com.example.calenderworkingtraining.ui.compose

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.calenderworkingtraining.model.WorkoutAssignment
import com.example.calenderworkingtraining.model.WorkoutStatus

@Composable
fun WorkoutItem(
    workout: WorkoutAssignment,
    onWorkoutToggle: (String) -> Unit
) {
    val backgroundColor = when (WorkoutStatus.fromValue(workout.status)) {
        WorkoutStatus.MISSED -> Color(0xFFF7F8FC)
        WorkoutStatus.COMPLETED -> Color(0xFF7470EF)
        WorkoutStatus.ASSIGNED -> Color(0xFFE0E0FF)
    }

    Box(
        modifier = Modifier.fillMaxWidth().padding(bottom = 5.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onWorkoutToggle(workout.id) }
                .background(backgroundColor, shape = RoundedCornerShape(5.dp))
                .padding(horizontal = 10.dp, vertical = 10.dp).padding(start = 10.dp)

        ) {
            Box(
                modifier = Modifier
                    .weight(0.8f)

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = workout.title.take(20) + if (workout.title.length > 20) "..." else "",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${workout.exercisesCount} exercises",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.DarkGray
                    )

                }
            }
            Box(
                modifier = Modifier.weight(0.2f)
            ) {
                if (WorkoutStatus.fromValue(workout.status) == WorkoutStatus.COMPLETED) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Completed",
                        tint = Color.Green
                    )
                }
            }

        }
    }
}