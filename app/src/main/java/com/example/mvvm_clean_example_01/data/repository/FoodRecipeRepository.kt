package com.example.mvvm_clean_example_01.data.repository

import com.example.mvvm_clean_example_01.data.model.FoodRecipe
import com.example.mvvm_clean_example_01.data.remotedata.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class FoodRecipeRepository (private val remoteDataSource: RemoteDataSource = RemoteDataSource()) {
    suspend fun getFoodRecipes(queries: Map<String, String>): Flow<List<FoodRecipe>> = flow {
         var foodRecipes:MutableList<FoodRecipe> = mutableListOf()
        val foodRecipe = remoteDataSource.getFoodRecipes(queries)
        for (food in foodRecipe.results){
            foodRecipes.add(FoodRecipe(food.image, food.title, food.pricePerServing, food.summary, food.id))
        }
        emit(foodRecipes)
    }.flowOn(Dispatchers.IO)
}