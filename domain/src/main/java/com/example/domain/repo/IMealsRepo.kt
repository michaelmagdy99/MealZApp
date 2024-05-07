package com.example.domain.repo

import com.example.domain.entity.CategoryResponse

interface IMealsRepo {
    suspend fun getMealsFromRemote() : CategoryResponse
}