package com.nameisjayant.mysalon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nameisjayant.mysalon.databinding.TimerEachRowBinding
import com.nameisjayant.mysalon.models.AppointmentTimeSlot

class AvailableTimeSlotAdapter(
    val context: Context
) : ListAdapter<AppointmentTimeSlot, AvailableTimeSlotAdapter.TimeSlotViewHolder>(TimeSlotDiffUtils) {


    inner class TimeSlotViewHolder(private val binding : TimerEachRowBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(slots: AppointmentTimeSlot) {
            binding.apply {
                time.text = slots.time
            }
        }
    }

    object TimeSlotDiffUtils : DiffUtil.ItemCallback<AppointmentTimeSlot>() {
        override fun areItemsTheSame(oldItem: AppointmentTimeSlot, newItem: AppointmentTimeSlot): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AppointmentTimeSlot, newItem: AppointmentTimeSlot): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeSlotViewHolder {
        return TimeSlotViewHolder(
            TimerEachRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TimeSlotViewHolder, position: Int) {
        val data = getItem(position)
        data?.let {
            val timeArray = it.time.split(":")
            if(timeArray[1].equals("00") || timeArray[1].equals("30")) {
                holder.bind(it)
            }else{
                holder.itemView.visibility = View.GONE
            }
        }
    }


}