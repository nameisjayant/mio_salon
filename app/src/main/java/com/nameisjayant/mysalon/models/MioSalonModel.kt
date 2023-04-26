package com.nameisjayant.mysalon.models

import com.nameisjayant.mysalon.R

data class MioSalonModel(
    val id: Int,
    val staffName: String,
    val appointments: List<Appointment>
)

data class Appointment(
    val uuid: Int,
    val id: Int,
    val time: String,
    val serviceName: String,
    val serviceDescription: String,
    val color: Int
)


val salonList = listOf(
    MioSalonModel(
        1,
        "Manjot",
        listOf(
            Appointment(
                1,
                1,
                "9:00 - 10:00",
                "SPA",
                "Spa Predicure(40min)",
                R.color.green
            ),
            Appointment(
                1,
                2,
                "9:00 - 10:00",
                "Neck Massage",
                "Spa Predicure(40min)",
                R.color.green
            ),
            Appointment(
                1,
                2,
                "9:00 - 10:00",
                "Neck Massage",
                "Spa Predicure(40min)",
                R.color.green
            ),
            Appointment(
                1,
                2,
                "9:00 - 10:00",
                "Neck Massage",
                "Spa Predicure(40min)",
                R.color.green
            ),
            Appointment(
                1,
                2,
                "9:00 - 10:00",
                "Neck Massage",
                "Spa Predicure(40min)",
                R.color.green
            ),
            Appointment(
                1,
                2,
                "9:00 - 10:00",
                "Neck Massage",
                "Spa Predicure(40min)",
                R.color.green
            ),
            Appointment(
                1,
                2,
                "9:00 - 10:00",
                "Neck Massage",
                "Spa Predicure(40min)",
                R.color.green
            )
        )
    ),
    MioSalonModel(
        2,
        "Karan",
        listOf(
            Appointment(
                1,
                2,
                "9:00 - 10:00",
                "HEAD MASSAGE",
                "HEAD MASSAGE",
                R.color.voilet
            )
        )
    ),
    MioSalonModel(
        3,
        "Navi",
        listOf(
            Appointment(
                3,
                3,
                "9:00 - 10:00",
                "HEAD MASSAGE",
                "Head message",
                R.color.red
            )
        )
    ),
    MioSalonModel(
        4,
        "Bablu",
        listOf(
            Appointment(
                2,
                4,
                "9:00 - 10:00",
                "SPA",
                "N-Oil Massage",
                R.color.blue
            )
        )
    ),
    MioSalonModel(
        5,
        "Mukesh",
        listOf(
            Appointment(
                3,
                5,
                "9:00 - 10:00",
                "HEAD MASSAGE",
                "Detan with gold mask male",
                R.color.green
            )
        )
    ),
    MioSalonModel(
        6,
        "Deepak",
        listOf(
            Appointment(
                1,
                6,
                "9:00 - 10:00",
                "HEAD MASSAGE",
                "Root Touch",
                R.color.voilet
            )
        )
    ),
    MioSalonModel(
        1,
        "Neha",
        listOf(
            Appointment(
                1,
                1,
                "9:00 - 10:00",
                "HEAD MASSAGE",
                "Global Slide",
                R.color.red
            )
        )
    )
)