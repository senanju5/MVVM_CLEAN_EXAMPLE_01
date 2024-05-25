package com.example.mvvm_clean_example_01.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_clean_example_01.domain.RecipeUsecase
import com.example.mvvm_clean_example_01.model.FoodRecipe
import kotlinx.coroutines.launch

class MainViewModel(private val recipeUsecase: RecipeUsecase):ViewModel() {

    public val foodRecipe = MutableLiveData<FoodRecipe>()

    fun getFoodRecipe(queries: Map<String, String>) {
        viewModelScope.launch {
            recipeUsecase.invoke(queries).collect {
                foodRecipe.value = it
            }
        }
    }
}