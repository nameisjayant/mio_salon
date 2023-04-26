package com.nameisjayant.mysalon.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nameisjayant.mysalon.R
import com.nameisjayant.mysalon.databinding.AppointmentEachRowBinding
import com.nameisjayant.mysalon.databinding.StaffEachRowBinding
import com.nameisjayant.mysalon.models.Appointment
import com.nameisjayant.mysalon.models.MioSalonModel


class AppointmentOuterAdapter(
    private val context: Context
) : ListAdapter<MioSalonModel, AppointmentOuterAdapter.AppointmentViewHolder>(OuterDiffUtils) {


    inner class AppointmentViewHolder(private val binding: StaffEachRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mioSalonModel: MioSalonModel) {
            binding.apply {
                staffName.text = mioSalonModel.staffName
                val mLayoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                innerRecyclerview.apply {
                    stopScroll()
                    layoutManager = mLayoutManager
                    setHasFixedSize(true)
                    adapter = AppointmentInnerAdapter(context).apply {
                        submitList(mioSalonModel.appointments)
                    }

                }
            }
        }
    }

    object OuterDiffUtils : DiffUtil.ItemCallback<MioSalonModel>() {
        override fun areItemsTheSame(oldItem: MioSalonModel, newItem: MioSalonModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MioSalonModel, newItem: MioSalonModel): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder {
        return AppointmentViewHolder(
            StaffEachRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        val data = getItem(position)
        data?.let {
            holder.bind(it)
        }
    }
}


class AppointmentInnerAdapter(private val context: Context) :
    ListAdapter<Appointment, AppointmentInnerAdapter.AppointmentInnerViewHolder>(InnerDiffUtils) {

    inner class AppointmentInnerViewHolder(private val binding: AppointmentEachRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("UseCompatLoadingForDrawables", "ResourceAsColor")
        fun bind(data: Appointment) {
            binding.apply {
                appointmentName.text = data.serviceName
                appointmentDesc.text = data.serviceDescription
                time.text = data.time
//                val gradientDrawable = ContextCompat.getDrawable(
//                    context,
//                    R.drawable.appointment_bg_shape
//                ) as GradientDrawable
//                gradientDrawable.setColor(data.color)
            }
        }
    }

    object InnerDiffUtils : DiffUtil.ItemCallback<Appointment>() {
        override fun areItemsTheSame(oldItem: Appointment, newItem: Appointment): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Appointment, newItem: Appointment): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentInnerViewHolder {
        return AppointmentInnerViewHolder(
            AppointmentEachRowBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AppointmentInnerViewHolder, position: Int) {
        val data = getItem(position)
        data?.let {
            holder.bind(it)
        }
    }

}