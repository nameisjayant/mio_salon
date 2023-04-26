package com.nameisjayant.mysalon.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nameisjayant.mysalon.R
import com.nameisjayant.mysalon.databinding.AppointmentEachRowBinding
import com.nameisjayant.mysalon.databinding.StaffEachRowBinding
import com.nameisjayant.mysalon.databinding.TimerEachRowBinding
import com.nameisjayant.mysalon.models.Appointment
import com.nameisjayant.mysalon.models.AppointmentTimeSlot
import com.nameisjayant.mysalon.models.MioSalonModel
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Random


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
                    //stopScroll()
                    layoutManager = mLayoutManager
                    // setHasFixedSize(true)
                    adapter = AppointmentInnerAdapter(context, mioSalonModel.appointments).apply {
                        submitList(mioSalonModel.appointmentTimeSlotList)
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




class AppointmentInnerAdapter(
    private val context: Context,
    private val appointment : List<Appointment>
) : ListAdapter<AppointmentTimeSlot, AppointmentInnerAdapter.AppointmentInnerViewHolder>(InnerDiffUtils) {

    private var bgColor: Int = ContextCompat.getColor(context, R.color.voilet)
    var slotTime = ""
    var appointmentStartTime= ""
    var appointmentEndTime = ""

    inner class AppointmentInnerViewHolder(private val binding: AppointmentEachRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val parent = binding.appointmentRow
        @SuppressLint("UseCompatLoadingForDrawables", "ResourceAsColor")
        fun bind(sData: AppointmentTimeSlot, data : Appointment) {
            binding.apply {
                appointmentName.text = data.serviceName
                appointmentDesc.text = data.serviceDescription
                time.text = data.startTime +" - "+data.endTime
//                val gradientDrawable = ContextCompat.getDrawable(
//                    context,
//                    R.drawable.appointment_bg_shape
//                ) as GradientDrawable
//                gradientDrawable.setColor(data.color)
            }
        }
    }

    object InnerDiffUtils : DiffUtil.ItemCallback<AppointmentTimeSlot>() {
        override fun areItemsTheSame(oldItem: AppointmentTimeSlot, newItem: AppointmentTimeSlot): Boolean {
            return oldItem.time == newItem.time
        }

        override fun areContentsTheSame(oldItem: AppointmentTimeSlot, newItem: AppointmentTimeSlot): Boolean {
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
        val availableSlot = getItem(position)


        availableSlot?.let {
                 slotTime = it.time
                val appointment = appointment.filter { it.startTime == slotTime }
                if(appointment.isNotEmpty()) {
                    appointmentStartTime = appointment.get(0).startTime
                    appointmentEndTime = appointment.get(0).endTime

                    val rnd = Random()
                    bgColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
                    holder.parent.setBackgroundColor(bgColor)

                    holder.bind(it, appointment.get(0))
                    holder.itemView.visibility = View.VISIBLE
                }else{

                    if(appointmentStartTime.isNotEmpty() && appointmentEndTime.isNotEmpty()) {

                        val slotTimeInSecond = slotTime.toSeconds("HH:mm")
                        val appointmentStartTimeInSecond = appointmentStartTime.toSeconds("HH:mm")
                        val appointmentEndTimeInSecond = appointmentEndTime.toSeconds("HH:mm")

                        if (slotTimeInSecond >= appointmentStartTimeInSecond && slotTimeInSecond <= appointmentEndTimeInSecond) {
                            holder.parent.setBackgroundColor(bgColor)
                        } else {
                            holder.itemView.visibility = View.GONE
                        }

                    }else{
                        holder.itemView.visibility = View.GONE
                    }
                }
        }
    }

    fun String.toSeconds(inputFormat: String): Int {
        val date = SimpleDateFormat(inputFormat, Locale.getDefault()).parse(this)
        return date?.time?.div(1000)?.toInt() ?: 0
    }


    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

}