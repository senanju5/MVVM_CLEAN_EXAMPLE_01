package com.example.mvvm_clean_example_01.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mvvm_clean_example_01.R
import com.example.mvvm_clean_example_01.data.model.FoodRecipe
import com.example.mvvm_clean_example_01.data.network.model.RemoteFoodRecipe
import com.example.mvvm_clean_example_01.data.network.model.Result

class RecipeAdapter:RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
    private  var recipes = emptyList<FoodRecipe>()
    class RecipeViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
           val titleTextView = itemView.findViewById<TextView>(R.id.titleText)
           val priceTextView = itemView.findViewById<TextView>(R.id.priceText)
           val recipeImageView = itemView.findViewById<ImageView>(R.id.imageView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeAdapter.RecipeViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.food_item_view,parent,false))
    }

    override fun onBindViewHolder(holder: RecipeAdapter.RecipeViewHolder, position: Int) {
        holder.titleTextView.text = recipes[position].title
        holder.priceTextView.text = recipes[position].pricePerServing.toString()
        holder.recipeImageView.load(recipes[position].image){
            crossfade(true)
            crossfade(600)
        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    fun setData (newData: List<FoodRecipe>) {
        recipes = newData
        notifyDataSetChanged()
    }
}