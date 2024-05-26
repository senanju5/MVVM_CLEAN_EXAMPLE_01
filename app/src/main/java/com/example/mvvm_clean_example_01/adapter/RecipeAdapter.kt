package com.example.mvvm_clean_example_01.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mvvm_clean_example_01.R
import com.example.mvvm_clean_example_01.data.model.FoodRecipe
import com.example.mvvm_clean_example_01.databinding.FoodItemViewBinding

class RecipeAdapter(private val clickListener:(FoodRecipe)->Unit):ListAdapter<FoodRecipe,RecipeAdapter.RecipeViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FoodRecipe>() {
            override fun areItemsTheSame(oldItem: FoodRecipe, newItem: FoodRecipe): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: FoodRecipe, newItem: FoodRecipe): Boolean {
                return oldItem == newItem
            }
        }        }
    class RecipeViewHolder(private val binding: FoodItemViewBinding, private val clickListener:(FoodRecipe)->Unit) :RecyclerView.ViewHolder(binding.root) {
        fun onBindView(foodRecipe: FoodRecipe) {
            binding.titleText.text = (foodRecipe.title)
            binding.priceText.text = ("Price: "+foodRecipe.pricePerServing.toString())

            binding.imageView.load(foodRecipe.image){
                crossfade(true)
                crossfade(600)
            }
            itemView.setOnClickListener {
                clickListener(foodRecipe)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeViewHolder {
        val binding = FoodItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RecipeViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.onBindView(getItem(position))
    }
}