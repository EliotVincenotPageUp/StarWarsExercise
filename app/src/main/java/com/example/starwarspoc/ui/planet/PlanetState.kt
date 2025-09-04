package com.example.starwarspoc.ui.planet

import com.example.starwarspoc.domain.Planets

data class PlanetState (
    val planets : List<Planets> = emptyList(),
)