package com.example.calenderworkingtraining.model.repository

import com.example.calenderworkingtraining.model.WorkoutApiResponse
import com.example.calenderworkingtraining.model.service.WorkoutApiService
import javax.inject.Inject

class WorkoutRepository @Inject constructor(private val apiService: WorkoutApiService) {

    suspend fun getWorkouts(): WorkoutApiResponse {
        return apiService.getWorkouts()
    }
}