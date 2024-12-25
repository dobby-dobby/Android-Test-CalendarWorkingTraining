package com.example.calenderworkingtraining.model

import com.google.gson.annotations.SerializedName

data class WorkoutDay(
    @SerializedName("_id")
    val id: String,
    @SerializedName("assignments")
    val assignments: List<WorkoutAssignment>,
    @SerializedName("trainer")
    val trainer: String,
    @SerializedName("client")
    val client: String,
    @SerializedName("day")
    val day: String,
    @SerializedName("date")
    val date: String
)