package com.example.calenderworkingtraining.model

import com.google.gson.annotations.SerializedName

data class WorkoutAssignment(
    @SerializedName("_id")
    val id: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("client")
    val client: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("day")
    val day: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("exercises_completed")
    val exercisesCompleted: Int,
    @SerializedName("exercises_count")
    val exercisesCount: Int
)
