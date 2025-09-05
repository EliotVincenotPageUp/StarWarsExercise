package com.example.starwarspoc.domain

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Entity(
    indices = [
        Index("id"),
    ]
)

@Serializable
data class Movie (

    @PrimaryKey(autoGenerate = true) val uid: Int? = null,

    @SerialName("title")
    val name : String,

    @SerialName("opening_crawl")
    val description : String,

    @SerialName("producer")
    val producer: String,
)

