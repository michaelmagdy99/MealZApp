package com.example.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CategoriesItem(
	val strCategory: String? = null,
	val strCategoryDescription: String? = null,
	@PrimaryKey val idCategory: String? = null,
	val strCategoryThumb: String? = null
)