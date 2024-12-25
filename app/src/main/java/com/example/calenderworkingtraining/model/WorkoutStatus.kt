package com.example.calenderworkingtraining.model

enum class WorkoutStatus(val value: Int) {
    MISSED(0), ASSIGNED(1), COMPLETED(2);

    companion object {
        fun fromValue(value: Int): WorkoutStatus {
            return entries.find { it.value == value } ?: ASSIGNED
        }
    }
}