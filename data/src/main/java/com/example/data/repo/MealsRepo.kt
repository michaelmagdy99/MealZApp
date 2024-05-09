package com.example.data.repo

import com.example.data.local.MealsDao
import com.example.data.remote.ApiService
import com.example.domain.entity.CategoriesItem
import com.example.domain.entity.CategoryResponse
import com.example.domain.repo.IMealsRepo

class MealsRepo(private val apiService: ApiService, private val mealsDao : MealsDao) : IMealsRepo {

    override suspend fun getMealsFromRemote(): CategoryResponse = apiService.getMeals()


    override suspend fun getMealsFromLocal(): List<CategoriesItem> {
        return mealsDao.getCategories()
    }

    override suspend fun saveMealsToLocal(categories: List<CategoriesItem?>?) {
        mealsDao.insertCategories(categories)
    }
}