
package com.example.mealz.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.CategoryResponse
import com.example.domain.usecase.GetMeals
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealsUseCase : GetMeals
) : ViewModel() {

    // a2der a3del 3leha
    private val _categories: MutableStateFlow<CategoryResponse?> = MutableStateFlow(null)

    // m4 3azheha tt8er
    val category: StateFlow<CategoryResponse?> = _categories

    fun getMeals() {
        viewModelScope.launch {
            try {
                _categories.value?.categories = getMealsUseCase()
            } catch (e: Exception) {
                Log.e("Meal view model", e.message.toString())
            }
        }
    }

}