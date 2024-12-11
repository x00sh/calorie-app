package uk.ac.westminster.hmmmmmm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

class RegistrationFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_registration, container, false)

        val nameEditText = view.findViewById<EditText>(R.id.editText1)
        val emailEditText = view.findViewById<EditText>(R.id.editText2)
        val passwordEditText = view.findViewById<EditText>(R.id.editText3)
        val ageEditText = view.findViewById<EditText>(R.id.editNumber)
        val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)
        val saveButton = view.findViewById<Button>(R.id.button)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val age = ageEditText.text.toString().toIntOrNull() ?: 0
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            val selectedOption = view.findViewById<RadioButton>(selectedRadioButtonId)?.text.toString()

            // Save data in SharedViewModel
            sharedViewModel.saveRegistrationData(name, email, password, age, selectedOption)

            // Navigate to another fragment (e.g., ConfirmationFragment)
            findNavController().navigate(R.id.action_RegistrationFragment_to_SecondFragment)
        }



        return view
    }
}
