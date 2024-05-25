package com.example.mvvm_clean_example_01.data.network

import com.example.mvvm_clean_example_01.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {


    val foodRecipeApi: FoodRecipeApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FoodRecipeApi::class.java)
    }
}