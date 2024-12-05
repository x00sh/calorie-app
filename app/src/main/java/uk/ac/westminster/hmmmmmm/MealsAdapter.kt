package uk.ac.westminster.hmmmmmm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MealsAdapter(private val meals: List<String>) :
    RecyclerView.Adapter<MealsAdapter.MealViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_meal, parent, false)
        return MealViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(meals[position])
    }

    override fun getItemCount(): Int = meals.size

    class MealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mealText: TextView = itemView.findViewById(R.id.tv_meal)

        fun bind(meal: String) {
            mealText.text = meal
        }
    }
}
