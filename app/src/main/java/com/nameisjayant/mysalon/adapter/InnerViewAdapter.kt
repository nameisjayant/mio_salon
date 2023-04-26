package com.nameisjayant.mysalon.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nameisjayant.mysalon.databinding.AppointmentEachRowBinding
import com.nameisjayant.mysalon.models.Appointments

class InnerViewAdapter : ListAdapter<Appointments, InnerViewAdapter.InnerViewHolder>(InnerDiff) {

    class InnerViewHolder(private val binding: AppointmentEachRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(appointments: Appointments) {
            binding.apply {
                appointmentName.text = appointments.appointName
            }
        }
    }

    private object InnerDiff : DiffUtil.ItemCallback<Appointments>() {
        override fun areItemsTheSame(oldItem: Appointments, newItem: Appointments): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Appointments, newItem: Appointments): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerViewHolder {
        return InnerViewHolder(
            AppointmentEachRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: InnerViewHolder, position: Int) {
        val appointments = getItem(position)
        appointments?.let {
            holder.bind(it)
        }
    }
}