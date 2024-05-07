package com.example.mealz.di

import com.example.domain.repo.IMealsRepo
import com.example.domain.usecase.GetMeals
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUseCase(iMealsRepo: IMealsRepo) : GetMeals{
        return GetMeals(iMealsRepo)
    }
}