package com.example.starwarspoc.ui.planet

sealed interface PlanetEvent {

    data object OnLoadPlanet : PlanetEvent
}