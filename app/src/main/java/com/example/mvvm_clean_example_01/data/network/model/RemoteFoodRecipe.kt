package com.example.mvvm_clean_example_01.data.network.model


import com.google.gson.annotations.SerializedName

data class RemoteFoodRecipe(
    @SerializedName("results")
    val results: List<Result>,

    )