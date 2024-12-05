package uk.ac.westminster.hmmmmmm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uk.ac.westminster.hmmmmmm.databinding.FragmentAddMealBinding

class AddMealFragment : Fragment() {

    private var _binding: FragmentAddMealBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddMealBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Save Meal Button Click
        binding.btnSaveMeal.setOnClickListener {
            val mealName = binding.etMealName.text.toString()
            val calories = binding.etCalories.text.toString()

            if (mealName.isBlank() || calories.isBlank()) {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                val bundle = Bundle().apply {
                    putString("mealName", mealName)
                    putInt("calories", calories.toInt())
                }
                findNavController().navigate(R.id.action_AddMealFragment_to_SecondFragment, bundle)
                Toast.makeText(requireContext(), "Meal Saved", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
