package com.example.calenderworkingtraining.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calenderworkingtraining.model.WorkoutDay
import com.example.calenderworkingtraining.model.WorkoutStatus
import com.example.calenderworkingtraining.model.repository.WorkoutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import java.time.LocalDate
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class WorkoutViewModel @Inject constructor(
    private val repository: WorkoutRepository
): ViewModel() {

    private val _workoutDays = MutableStateFlow<List<WorkoutDay>>(emptyList())
    val workoutDays: StateFlow<List<WorkoutDay>> = _workoutDays

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchWorkouts()
    }

    private fun fetchWorkouts() {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.value = true
            _workoutDays.value = repository.getWorkouts().dayData
            _isLoading.value = false
        }
    }

    fun toggleWorkout(workoutId: String) {
        viewModelScope.launch {
            val updatedDays = _workoutDays.value.map { day ->
                day.copy(assignments = day.assignments.map { assignment ->
                    if (assignment.id == workoutId) {
                        assignment.copy(
                            status = if (WorkoutStatus.fromValue(assignment.status) == WorkoutStatus.COMPLETED)
                                WorkoutStatus.ASSIGNED.value
                            else
                                WorkoutStatus.COMPLETED.value
                        )
                    } else {
                        assignment
                    }
                })
            }
            _workoutDays.value = updatedDays
        }
    }

    fun getCurrentWeek(): List<Pair<String, LocalDate,>> {
        val startOfWeek = LocalDate.of(2024, 5, 20) .with(DayOfWeek.MONDAY)
        return (0..6).map { offset ->
            val date = startOfWeek.plusDays(offset.toLong())
            date.dayOfWeek.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() } to date
        }
    }
}