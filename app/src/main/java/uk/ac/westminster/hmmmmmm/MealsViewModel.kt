package uk.ac.westminster.hmmmmmm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MealsViewModel : ViewModel() {
    val meals = MutableLiveData<MutableList<String>>(mutableListOf()) // List of meals
    val totalCalories = MutableLiveData<Int>(0) // Running total of calories

    // Function to add a meal and update total calories
    fun addMeal(mealName: String, calories: Int) {
        meals.value?.apply {
            add("$mealName: $calories kcal")
            totalCalories.value = (totalCalories.value ?: 0) + calories
        }
        meals.value = meals.value // Trigger observer update
    }
}
