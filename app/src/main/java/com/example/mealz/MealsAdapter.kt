package com.example.mealz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entity.CategoriesItem
import com.example.mealz.databinding.CategoryItemBinding

class MealsAdapter() : ListAdapter<CategoriesItem, MealsAdapter.ViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val itemBinding: CategoryItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(category: CategoriesItem) {
            itemBinding.categoryNameTv.text = category.strCategory
            itemBinding.categoryDesTv.text = category.strCategoryDescription
            Glide.with(itemBinding.root.context).load(category.strCategoryThumb).into(itemBinding.categoryIv)
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<CategoriesItem>() {
        override fun areItemsTheSame(
            oldItem: CategoriesItem,
            newItem: CategoriesItem
        ): Boolean {
            return oldItem.idCategory == newItem.idCategory
        }

        override fun areContentsTheSame(
            oldItem: CategoriesItem,
            newItem: CategoriesItem
        ): Boolean {
            return oldItem == newItem
        }
    }
}