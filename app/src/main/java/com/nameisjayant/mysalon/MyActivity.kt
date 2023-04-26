package com.nameisjayant.mysalon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nameisjayant.mysalon.adapter.AppointmentOuterAdapter
import com.nameisjayant.mysalon.adapter.OuterViewAdapter
import com.nameisjayant.mysalon.databinding.ActivityMainBinding
import com.nameisjayant.mysalon.models.Staff
import com.nameisjayant.mysalon.models.salonList

class MyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val staffs = listOf(
        Staff(1, "Catlina"),
        Staff(2, "Oliver"),
        Staff(3, "Amelia"),
        Staff(4, "Ethan"),
        Staff(5, "Nalon"),
        Staff(6, "Nathan"),
        Staff(7, "John")
    )


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
    }
}