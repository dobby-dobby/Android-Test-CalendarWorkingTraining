package com.example.calenderworkingtraining.model

import com.google.gson.annotations.SerializedName

data class WorkoutApiResponse(
    @SerializedName("day_data")
    val dayData: List<WorkoutDay>
)
