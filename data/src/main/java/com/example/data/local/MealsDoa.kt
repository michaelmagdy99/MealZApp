package com.example.data.local

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.domain.entity.CategoriesItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@Database(entities = [CategoriesItem::class], version = 1)
@TypeConverters(CategoriesItemTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): MealsDao
}

@Dao
interface MealsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories: List<CategoriesItem?>?)
    @Query("SELECT * FROM CategoriesItem")
    suspend fun getCategories(): List<CategoriesItem>
}


object CategoriesItemTypeConverter {

    private val gson = Gson()

    @TypeConverter
    @JvmStatic
    fun fromCategoriesItemList(categoriesItemList: List<CategoriesItem>?): String {
        return gson.toJson(categoriesItemList)
    }

    @TypeConverter
    @JvmStatic
    fun toCategoriesItemList(data: String): List<CategoriesItem> {
        val listType = object : TypeToken<List<CategoriesItem>>() {}.type
        return gson.fromJson(data, listType)
    }
}