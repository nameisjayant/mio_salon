package com.nameisjayant.mysalon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nameisjayant.mysalon.databinding.StaffEachRowBinding
import com.nameisjayant.mysalon.models.Appointments
import com.nameisjayant.mysalon.models.Staff

class OuterViewAdapter(
    private val context: Context
) : ListAdapter<Staff, OuterViewAdapter.OuterViewHolder>(OuterDiff) {

    inner class OuterViewHolder(private val binding: StaffEachRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(staff: Staff) {
            binding.apply {
                staffName.text = staff.staffName
                val mLayoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                innerRecyclerview.apply {
                    layoutManager = mLayoutManager
                    setHasFixedSize(true)
                    adapter = InnerViewAdapter().apply {
                        submitList(appointments)
                    }

                }
            }
        }
    }

    private object OuterDiff : DiffUtil.ItemCallback<Staff>() {
        override fun areItemsTheSame(oldItem: Staff, newItem: Staff): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Staff, newItem: Staff): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OuterViewHolder {
        return OuterViewHolder(
            StaffEachRowBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OuterViewHolder, position: Int) {
        val staff = getItem(position)
        staff?.let {
            holder.bind(it)
        }
    }

    companion object {
        val appointments = listOf(
            Appointments(1, "Spa"),
            Appointments(2, "Spa"),
            Appointments(3, "Spa pedicure"),
            Appointments(4, "Massage"),
            Appointments(5, "ester"),
            Appointments(6, "Massage"),
            Appointments(7, "Massage"),
            Appointments(8, "ester"),
            Appointments(9, "Massage"),
            Appointments(10, "Massage"),
            Appointments(11, "ester"),
            Appointments(12, "Massage"),
            Appointments(13, "Massage")
        )
    }
}

