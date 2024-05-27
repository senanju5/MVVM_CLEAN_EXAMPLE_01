package com.example.mvvm_clean_example_01.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mvvm_clean_example_01.data.model.FoodRecipe
import com.example.mvvm_clean_example_01.databinding.FoodItemViewBinding

class RecipeAdapter(private val clickListener:(position:Int)->Unit):ListAdapter<FoodRecipe,RecipeAdapter.RecipeViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FoodRecipe>() {
            override fun areItemsTheSame(oldItem: FoodRecipe, newItem: FoodRecipe): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: FoodRecipe, newItem: FoodRecipe): Boolean {
                return oldItem == newItem
            }
        }        }
    class RecipeViewHolder(private val binding: FoodItemViewBinding, private val clickListener:(position:Int)->Unit) :RecyclerView.ViewHolder(binding.root) {
        fun onBindView(foodRecipe: FoodRecipe, position: Int) {
            binding.titleText.text = (foodRecipe.title)
            binding.priceText.text = ("Price: "+foodRecipe.pricePerServing.toString())

            binding.imageView.load(foodRecipe.image){
                crossfade(true)
                crossfade(600)
            }
            itemView.setOnClickListener {
                clickListener(position)
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
        holder.onBindView(getItem(position), position)
    }
}