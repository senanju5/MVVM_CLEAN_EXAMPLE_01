package com.example.mvvm_clean_example_01.data.repository

import com.example.mvvm_clean_example_01.data.model.FoodRecipe
import com.example.mvvm_clean_example_01.data.remotedata.RemoteDataSource
import com.example.mvvm_clean_example_01.data.network.model.RemoteFoodRecipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class FoodRecipeRepository (private val remoteDataSource: RemoteDataSource) {
    suspend fun getFoodRecipes(queries: Map<String, String>): Flow<List<FoodRecipe>> = flow {
        var foodRecipes = ArrayList<FoodRecipe>()
        val foodRecipe = remoteDataSource.getFoodRecipes(queries)
        for (food in foodRecipe.results){
            foodRecipes.add(FoodRecipe(food.image, food.title, food.pricePerServing, food.summary, food.id))
        }
        emit(foodRecipes)
    }.flowOn(Dispatchers.IO)
}