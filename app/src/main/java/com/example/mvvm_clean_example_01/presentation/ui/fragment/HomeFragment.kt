package com.example.mvvm_clean_example_01.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_clean_example_01.R
import com.example.mvvm_clean_example_01.adapter.RecipeAdapter
import com.example.mvvm_clean_example_01.data.model.FoodRecipe
import com.example.mvvm_clean_example_01.data.remotedata.RemoteDataSource
import com.example.mvvm_clean_example_01.data.repository.FoodRecipeRepository
import com.example.mvvm_clean_example_01.domain.RecipeUsecase
import com.example.mvvm_clean_example_01.presentation.viewmodel.MainViewModel
import com.example.mvvm_clean_example_01.utils.Constants.Companion.API_KEY
import com.google.gson.Gson


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val  view = inflater.inflate(R.layout.fragment_home, container, false)
        val remoteDataSource = RemoteDataSource()
        val foodRecipeRepository = FoodRecipeRepository(remoteDataSource)
        val recipeUsecase = RecipeUsecase(foodRecipeRepository)
        val mainViewModel = MainViewModel(recipeUsecase)
        mainViewModel.getFoodRecipe(applyQueries())
        val recyclerView = view.findViewById<RecyclerView>(R.id.food_recipe_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        var adapter = RecipeAdapter {foodRecipe: FoodRecipe ->
            val recipe = Gson().toJson(foodRecipe)
            val bundle = bundleOf("recipe" to recipe)
          findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
        }
        recyclerView.adapter =adapter

        mainViewModel.remoteFoodRecipe.observe(viewLifecycleOwner) { response ->
            adapter.submitList(response)
        }

        return view
    }


    fun applyQueries(): HashMap<String, String> {
        var query: HashMap<String, String> = HashMap()
        query["number"] = "10"
        query["apiKey"] = API_KEY
        query["type"] = "snack"
        query["addRecipeInformation"] = "true"
        query["fillIngredients"] = "true"
        return query
    }
}
