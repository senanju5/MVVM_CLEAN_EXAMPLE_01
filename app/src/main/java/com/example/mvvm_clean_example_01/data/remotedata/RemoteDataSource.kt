package com.example.mvvm_clean_example_01.data.remotedata

import com.example.mvvm_clean_example_01.data.network.RetrofitClient
import com.example.mvvm_clean_example_01.model.FoodRecipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSource {
    suspend fun getFoodRecipes(queries: Map<String, String>):FoodRecipe{
       return RetrofitClient.foodRecipeApi.getFoodRecipes(queries)
    }
}