package com.example.starwarspoc.domain

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "user")
@Serializable
data class User (

    @PrimaryKey(autoGenerate = true)
    val uid: Int? = 0,

    val firstName : String
)
