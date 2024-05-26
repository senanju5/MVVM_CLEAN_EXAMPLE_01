package com.example.mvvm_clean_example_01.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_clean_example_01.data.model.FoodRecipe
import com.example.mvvm_clean_example_01.domain.RecipeUsecase
import kotlinx.coroutines.launch

class MainViewModel(private val recipeUsecase: RecipeUsecase):ViewModel() {

    public val remoteFoodRecipe = MutableLiveData<List<FoodRecipe>>()

    fun getFoodRecipe(queries: Map<String, String>) {
        viewModelScope.launch {
            recipeUsecase.invoke(queries).collect {
                remoteFoodRecipe.value = it
            }
        }
    }
}