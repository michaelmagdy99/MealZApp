package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.entity.CategoryResponse
import com.example.domain.repo.IMealsRepo

class MealsRepo(private val apiService: ApiService) : IMealsRepo {

    override suspend fun getMealsFromRemote(): CategoryResponse = apiService.getMeals()
}