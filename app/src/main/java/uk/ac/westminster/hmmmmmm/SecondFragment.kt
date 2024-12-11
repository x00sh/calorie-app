package uk.ac.westminster.hmmmmmm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import uk.ac.westminster.hmmmmmm.databinding.FragmentSecondBinding
import androidx.fragment.app.activityViewModels


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var viewModel: MealsViewModel // Reference to ViewModel
    private lateinit var adapter: MealsAdapter // Reference to Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get ViewModel instance
        viewModel = ViewModelProvider(requireActivity()).get(MealsViewModel::class.java)

        sharedViewModel.name.observe(viewLifecycleOwner, Observer { name ->
            binding.text1.text = "Name: $name"
        })

        sharedViewModel.email.observe(viewLifecycleOwner, Observer { email ->
            binding.text2.text = "Email: $email"
        })

        sharedViewModel.password.observe(viewLifecycleOwner, Observer { password ->
            binding.text3.text = "Password: $password"
        })

        sharedViewModel.age.observe(viewLifecycleOwner, Observer { age ->
            binding.text4.text = "Age: $age"
        })

        sharedViewModel.selectedOption.observe(viewLifecycleOwner, Observer { option ->
            binding.text5.text = "Selected Option: $option"
        })

        // Set up RecyclerView and Adapter
        adapter = MealsAdapter(viewModel.meals.value ?: mutableListOf())
        binding.rvMealsList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMealsList.adapter = adapter

        // Observe changes to meals and total calories
        viewModel.meals.observe(viewLifecycleOwner, Observer { updatedMeals ->
            adapter.notifyDataSetChanged() // Update the list view
        })

        viewModel.totalCalories.observe(viewLifecycleOwner, Observer { totalCalorieCount ->
            binding.tvCaloriesInfo.text = "Your Daily Calories: $totalCalorieCount kcal"
        })

        // Check if arguments are passed from AddMealFragment
        arguments?.let {
            val mealName = it.getString("mealName")
            val calories = it.getInt("calories")

            if (!mealName.isNullOrEmpty()) {
                // Add meal to list via ViewModel
                viewModel.addMeal(mealName, calories)
            }
        }

        // Navigate to Add Meal Page
        binding.btnAddMeal.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_AddMealFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



