package com.example.starwarspoc.ui.profil

import com.example.starwarspoc.domain.User

data class ProfilState(
    val users: List<User> = emptyList(),
    val firstName: String = "",
    val lastName: String = ""
)