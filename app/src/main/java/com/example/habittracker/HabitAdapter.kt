package com.example.habittracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HabitAdapter(
    private val habits: MutableList<Habit>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<HabitAdapter.HabitViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.habit_item, parent, false)
        return HabitViewHolder(itemView, itemClickListener)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        val currentHabit = habits[position]
        holder.textViewHabitName.text = currentHabit.name
    }

    override fun getItemCount() = habits.size

    class HabitViewHolder(itemView: View, itemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val textViewHabitName: TextView = itemView.findViewById(R.id.text_view_habit_name)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListener.onItemClick(position)
                }
            }
        }
    }
}
