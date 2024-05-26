package com.example.mvvm_clean_example_01.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_clean_example_01.R
import com.example.mvvm_clean_example_01.adapter.RecipeAdapter
import com.example.mvvm_clean_example_01.data.model.FoodRecipe
import com.example.mvvm_clean_example_01.data.remotedata.RemoteDataSource
import com.example.mvvm_clean_example_01.data.repository.FoodRecipeRepository
import com.example.mvvm_clean_example_01.databinding.FragmentHomeBinding
import com.example.mvvm_clean_example_01.domain.RecipeUsecase
import com.example.mvvm_clean_example_01.presentation.viewmodel.MainViewModel
import com.example.mvvm_clean_example_01.presentation.viewmodel.ViewModelFactory
import com.example.mvvm_clean_example_01.utils.Constants.Companion.API_KEY
import com.google.gson.Gson


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private val viewModel: MainViewModel by activityViewModels<MainViewModel>()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel.getFoodRecipe(applyQueries())

        val recyclerView = binding.foodRecipeRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        var adapter = RecipeAdapter {position: Int ->
            val bundle = Bundle()
            bundle.putInt("position", position)

          findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
        }
        recyclerView.adapter =adapter

        viewModel.remoteFoodRecipe.observe(viewLifecycleOwner) { response ->
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
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
