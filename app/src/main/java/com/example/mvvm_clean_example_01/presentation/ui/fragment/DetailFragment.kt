package com.example.mvvm_clean_example_01.presentation.ui.fragment

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
import com.example.mvvm_clean_example_01.databinding.FragmentDetailBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {

    private  lateinit var _binding: FragmentDetailBinding
    private val binding get() = _binding
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
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root

        setData(recipe)
        return view
    }

    private fun setData(recipe: FoodRecipe) {
        binding.title.text = recipe.title
        binding.price.text = recipe.pricePerServing.toString()
        binding.summary.text = recipe.summary
        binding.foodImage.load(recipe.image)
    }

}