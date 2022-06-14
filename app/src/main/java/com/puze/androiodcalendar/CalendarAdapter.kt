package com.puze.androiodcalendar

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.puze.androiodcalendar.databinding.CalendarItemBinding

class CalendarAdapter(private val itemList: ArrayList<CalendarItem>) :
    RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {
    val TAG = "Calendar"

    inner class ViewHolder(private val binding: CalendarItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.calendarItem.setOnClickListener {
                val item = itemList[bindingAdapterPosition]
                Log.d(TAG, "calendar item : ${item.day}")
            }
        }

        fun bind(calendarItem: CalendarItem) {
            if (calendarItem.day == 0) {
                binding.calendarItemDate.text = ""
            } else {
                binding.calendarItemDate.text = calendarItem.day.toString()
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CalendarItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}