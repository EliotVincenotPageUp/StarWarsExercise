package com.example.starwarspoc.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Planets(

    val name: String,

    @SerialName("rotation_period")
    val rotationPeriod: String,

    val diameter: String,


)