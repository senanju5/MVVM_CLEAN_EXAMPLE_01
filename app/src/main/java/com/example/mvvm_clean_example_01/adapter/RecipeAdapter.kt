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
import com.example.mvvm_clean_example_01.data.network.model.RemoteFoodRecipe
import com.example.mvvm_clean_example_01.data.network.model.Result

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
    class RecipeViewHolder(itemView: View, private val clickListener:(FoodRecipe)->Unit) :RecyclerView.ViewHolder(itemView) {
           val titleTextView = itemView.findViewById<TextView>(R.id.titleText)
           val priceTextView = itemView.findViewById<TextView>(R.id.priceText)
           val recipeImageView = itemView.findViewById<ImageView>(R.id.imageView)


        fun onBindView(foodRecipe: FoodRecipe) {
           titleTextView.text = (foodRecipe.title)
            priceTextView.text = ("Price: "+foodRecipe.pricePerServing.toString())
            recipeImageView.load(foodRecipe.image){
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
    ): RecipeAdapter.RecipeViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.food_item_view,parent,false), clickListener)
    }

    override fun onBindViewHolder(holder: RecipeAdapter.RecipeViewHolder, position: Int) {
        holder.onBindView(getItem(position))
    }
}