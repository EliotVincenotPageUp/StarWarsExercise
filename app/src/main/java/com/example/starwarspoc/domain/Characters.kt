package com.example.starwarspoc.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Characters (

    val name : String,
    val height: String,
    val gender : String,

    @SerialName("birth_year")
    val birthday: String,
)

