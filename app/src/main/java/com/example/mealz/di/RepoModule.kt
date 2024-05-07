package com.example.mealz.di

import com.example.data.remote.ApiService
import com.example.data.repo.MealsRepo
import com.example.domain.repo.IMealsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(apiService: ApiService): IMealsRepo {
        return MealsRepo(apiService)
    }
}