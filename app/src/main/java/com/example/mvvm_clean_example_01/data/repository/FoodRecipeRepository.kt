package com.example.mvvm_clean_example_01.data.repository

import com.example.mvvm_clean_example_01.data.remotedata.RemoteDataSource
import com.example.mvvm_clean_example_01.model.FoodRecipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class FoodRecipeRepository (private val remoteDataSource: RemoteDataSource) {
    suspend fun getFoodRecipes(queries: Map<String, String>): Flow<FoodRecipe> = flow {
        val foodRecipe = remoteDataSource.getFoodRecipes(queries)
        emit(foodRecipe)
    }.flowOn(Dispatchers.IO)
}