package com.nameisjayant.mysalon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nameisjayant.mysalon.adapter.AppointmentOuterAdapter
import com.nameisjayant.mysalon.adapter.AvailableTimeSlotAdapter
import com.nameisjayant.mysalon.adapter.OuterViewAdapter
import com.nameisjayant.mysalon.databinding.ActivityMainBinding
import com.nameisjayant.mysalon.models.Staff
import com.nameisjayant.mysalon.models.appointmentTimeSlotList
import com.nameisjayant.mysalon.models.salonList

class MyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.outerRecyclerview.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(this@MyActivity, LinearLayoutManager.HORIZONTAL, false)
            // layoutManager = CustomLayoutManager(this@MyActivity)
            adapter = AppointmentOuterAdapter(this@MyActivity).apply {
                submitList(salonList)
            }
        }

        val tLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.timerRecyclerview.apply {
            //stopScroll()
            layoutManager = tLayoutManager
            // setHasFixedSize(true)
            adapter = AvailableTimeSlotAdapter(context).apply {
                submitList(appointmentTimeSlotList)
            }

        }
    }
}