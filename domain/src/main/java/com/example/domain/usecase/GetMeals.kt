package com.example.domain.usecase

import com.example.domain.repo.IMealsRepo

class GetMeals(private val mealsRepo : IMealsRepo) {
    //fun m3rofa b2sem el class
    //ya3ni mmkn andha leh kda
    //GetMeals() 3l4an hey operator

    suspend operator fun invoke() = mealsRepo.getMealsFromRemote()
}
