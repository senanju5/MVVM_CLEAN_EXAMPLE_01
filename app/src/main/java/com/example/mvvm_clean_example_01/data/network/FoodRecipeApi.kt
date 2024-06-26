package com.example.mvvm_clean_example_01.data.network

import com.example.mvvm_clean_example_01.data.network.model.RemoteFoodRecipe
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface FoodRecipeApi {
    @GET("/recipes/complexSearch")
    suspend fun getFoodRecipes(@QueryMap queries: Map<String, String>): RemoteFoodRecipe
}