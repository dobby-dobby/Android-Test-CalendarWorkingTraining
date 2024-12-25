package com.example.calenderworkingtraining.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.calenderworkingtraining.viewmodel.WorkoutViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calenderworkingtraining.ui.compose.DayContainer
import java.time.ZonedDateTime

@Composable
fun WorkoutScheduleScreen(viewModel: WorkoutViewModel = hiltViewModel()) {

    val workoutState by viewModel.workoutDays.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        viewModel.getCurrentWeek().forEach { (dayOfWeek, date) ->
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    Box(
                        modifier = Modifier
                            .weight(0.2f)
                            .padding(horizontal = 20.dp, vertical = 10.dp)
                    ) {
                        Column(horizontalAlignment = Alignment.Start) {
                            Text(
                                text = dayOfWeek.substring(0, 3),
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.Gray
                            )
                            Text(
                                text = date.dayOfMonth.toString(),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .weight(0.8f)
                            .padding(vertical = 10.dp, horizontal = 10.dp)
                    ) {
                        workoutState.forEach { it ->
                            if (ZonedDateTime.parse(it.date).toLocalDate() == date) {
                                DayContainer(it, onWorkoutToggle = {
                                    viewModel.toggleWorkout(it)
                                })
                            }
                        }
                    }
                }
                HorizontalDivider()
            }
        }
    }
}

