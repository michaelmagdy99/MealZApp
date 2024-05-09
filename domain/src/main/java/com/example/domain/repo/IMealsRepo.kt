package com.example.domain.repo

import com.example.domain.entity.CategoriesItem
import com.example.domain.entity.CategoryResponse

interface IMealsRepo {
    suspend fun getMealsFromRemote() : CategoryResponse
    suspend fun getMealsFromLocal(): List<CategoriesItem>
    suspend fun saveMealsToLocal(categories: List<CategoriesItem?>?)
}