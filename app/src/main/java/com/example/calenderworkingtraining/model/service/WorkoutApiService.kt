package com.example.calenderworkingtraining.model.service

import com.example.calenderworkingtraining.model.WorkoutApiResponse
import retrofit2.http.GET

interface WorkoutApiService {

    @GET("workouts")
    suspend fun getWorkouts(): WorkoutApiResponse
}