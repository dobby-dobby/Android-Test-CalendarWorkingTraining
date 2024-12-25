package com.example.calenderworkingtraining.di

import com.example.calenderworkingtraining.model.repository.WorkoutRepository
import com.example.calenderworkingtraining.model.service.WorkoutApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://demo6732818.mockable.io/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): WorkoutApiService {
        return retrofit.create(WorkoutApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideWorkoutRepository(apiService: WorkoutApiService): WorkoutRepository {
        return WorkoutRepository(apiService)
    }
}