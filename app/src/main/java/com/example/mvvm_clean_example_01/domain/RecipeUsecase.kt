package com.example.mvvm_clean_example_01.domain

import com.example.mvvm_clean_example_01.data.repository.FoodRecipeRepository
import com.example.mvvm_clean_example_01.data.network.model.RemoteFoodRecipe
import kotlinx.coroutines.flow.Flow

class RecipeUsecase(private val recipeRepository: FoodRecipeRepository) {
    suspend operator fun invoke(queries: Map<String, String>): Flow<RemoteFoodRecipe> {
        return recipeRepository.getFoodRecipes(queries)
    }
}