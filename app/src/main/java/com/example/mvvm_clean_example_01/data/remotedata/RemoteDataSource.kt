package com.example.mvvm_clean_example_01.data.remotedata

import com.example.mvvm_clean_example_01.data.network.RetrofitClient
import com.example.mvvm_clean_example_01.data.network.model.RemoteFoodRecipe

class RemoteDataSource {
    suspend fun getFoodRecipes(queries: Map<String, String>): RemoteFoodRecipe {
       return RetrofitClient.foodRecipeApi.getFoodRecipes(queries)
    }
}