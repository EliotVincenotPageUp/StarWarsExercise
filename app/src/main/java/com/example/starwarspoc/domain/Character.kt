package com.example.starwarspoc.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Character (

    @SerialName("name")
    val name : String,

    @SerialName("height")
    val height: String,

    @SerialName("gender")
    val gender : String,

    @SerialName("birth_year")
    val birthday: String,
)

