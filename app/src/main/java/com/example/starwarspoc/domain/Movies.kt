package com.example.starwarspoc.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movies (
    @SerialName("title")
    val name : String,

    @SerialName("opening_crawl")
    val description : String,

    @SerialName("producer")
    val producer: String,

)

