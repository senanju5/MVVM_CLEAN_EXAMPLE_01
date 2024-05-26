package com.example.mvvm_clean_example_01.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_clean_example_01.domain.RecipeUsecase

class ViewModelFactory (private val recipeUsecase: RecipeUsecase=RecipeUsecase()): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(recipeUsecase) as T
    }

}