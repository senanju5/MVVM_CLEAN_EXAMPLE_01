package com.example.mvvm_clean_example_01.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.example.mvvm_clean_example_01.R
import com.example.mvvm_clean_example_01.data.model.FoodRecipe
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val recipeJson = arguments?.getString("recipe")
        val recipeType = object : TypeToken<FoodRecipe>() {}.type
        val recipe: FoodRecipe = Gson().fromJson(recipeJson ,recipeType)

        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        setData(view,recipe)
        return view
    }

    private fun setData(view: View,recipe: FoodRecipe) {
        view.findViewById<TextView>(R.id.title).text = recipe.title
        view.findViewById<TextView>(R.id.price).text = recipe.pricePerServing.toString()
        view.findViewById<TextView>(R.id.summary).text = recipe.summary
        view.findViewById<ImageView>(R.id.foodImage).load(recipe.image)
    }

}