package com.example.starwarspoc.ui.planet

import com.example.starwarspoc.domain.Planet

data class PlanetState (
    val planets : List<Planet> = emptyList(),
)