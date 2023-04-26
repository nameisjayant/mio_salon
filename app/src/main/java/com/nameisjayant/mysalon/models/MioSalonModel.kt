package com.nameisjayant.mysalon.models

import com.nameisjayant.mysalon.R

data class MioSalonModel(
    val id: Int,
    val staffName: String,
    val appointments: List<Appointment>,
    val appointmentTimeSlotList: List<AppointmentTimeSlot>
)

data class Appointment(
    val uuid: Int,
    val id: Int,
    val startTime: String,
    val endTime : String,
    val serviceName: String,
    val serviceDescription: String,
    val color: Int
)

data class AppointmentTimeSlot(
    val id : Int,
    val time : String
)


val appointmentTimeSlotList = listOf(
    AppointmentTimeSlot(1,"9:00"),
    AppointmentTimeSlot(2,"9:10"),
    AppointmentTimeSlot(3,"9:20"),
    AppointmentTimeSlot(4,"9:30"),
    AppointmentTimeSlot(5,"9:40"),
    AppointmentTimeSlot(6,"9:50"),
    AppointmentTimeSlot(7,"10:00"),
    AppointmentTimeSlot(8,"10:10"),
    AppointmentTimeSlot(9,"10:20"),
    AppointmentTimeSlot(10,"10:30"),
    AppointmentTimeSlot(11,"10:40"),
    AppointmentTimeSlot(12,"10:50"),
    AppointmentTimeSlot(13,"11:00"),
    AppointmentTimeSlot(14,"11:10"),
    AppointmentTimeSlot(15,"11:20"),
    AppointmentTimeSlot(16,"11:30"),
    AppointmentTimeSlot(17,"11:40"),
    AppointmentTimeSlot(18,"11:50"),
    AppointmentTimeSlot(19,"12:00")
)

val salonList = listOf(
    MioSalonModel(
        1,
        "Manjot",
        listOf(
            Appointment(
                1,
                1,
                "9:30",
                "10:00",
                "SPA",
                "Spa Predicure(40min)",
                R.color.green
            ),
            Appointment(
                1,
                2,
                "10:20",
                "10:50",
                "Neck Massage",
                "Spa Predicure(40min)",
                R.color.green
            ),
            Appointment(
                1,
                2,
                "11:00",
                "11:30",
                "Neck Massage",
                "Spa Predicure(40min)",
                R.color.green
            ),
            Appointment(
                1,
                2,
                "11:30",
                "12:00",
                "Neck Massage",
                "Spa Predicure(40min)",
                R.color.green
            )

        ),
        appointmentTimeSlotList
    ),
    MioSalonModel(
        2,
        "Karan",
        listOf(
            Appointment(
                1,
                2,
                "9:00",
                "10:00",
                "HEAD MASSAGE",
                "HEAD MASSAGE",
                R.color.voilet
            )
        ),
 appointmentTimeSlotList
    ),
    MioSalonModel(
        3,
        "Navi",
        listOf(
            Appointment(
                3,
                3,
                "9:00",
                "10:00",
                "HEAD MASSAGE",
                "Head message",
                R.color.red
            )
        ),
 appointmentTimeSlotList
    ),
    MioSalonModel(
        4,
        "Bablu",
        listOf(
            Appointment(
                2,
                4,
                "9:00",
                "10:00",
                "SPA",
                "N-Oil Massage",
                R.color.blue
            )
        ),
 appointmentTimeSlotList
    ),
    MioSalonModel(
        5,
        "Mukesh",
        listOf(
            Appointment(
                3,
                5,
                "9:00",
                "10:00",
                "HEAD MASSAGE",
                "Detan with gold mask male",
                R.color.green
            )
        ),
 appointmentTimeSlotList
    ),
    MioSalonModel(
        6,
        "Deepak",
        listOf(
            Appointment(
                1,
                6,
                "9:00",
                "10:00",
                "HEAD MASSAGE",
                "Root Touch",
                R.color.voilet
            )
        ),
 appointmentTimeSlotList
    ),
    MioSalonModel(
        1,
        "Neha",
        listOf(
            Appointment(
                1,
                1,
                "9:00",
                "10:00",
                "HEAD MASSAGE",
                "Global Slide",
                R.color.red
            )
        ),
 appointmentTimeSlotList
    )
)