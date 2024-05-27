package com.example.mvvm_clean_example_01.domain

import com.example.mvvm_clean_example_01.data.model.FoodRecipe
import com.example.mvvm_clean_example_01.data.repository.FoodRecipeRepository
import kotlinx.coroutines.flow.Flow

class RecipeUsecase(private val recipeRepository: FoodRecipeRepository = FoodRecipeRepository()) {
    suspend operator fun invoke(queries: Map<String, String>): Flow<List<FoodRecipe>> {
        return recipeRepository.getFoodRecipes(queries)
    }
}