package com.example.starwarspoc.ui.planet

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarspoc.data.datasource.getPlanets
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlanetViewModel : ViewModel() {

    private val _state = MutableStateFlow(PlanetState())
    val state: StateFlow<PlanetState> = _state.asStateFlow()

    fun onEvent(event: PlanetEvent) {
        Log.d("PlanetViewModel", "onEvent reçu: $event")
        when (event) {
            PlanetEvent.OnLoadPlanet -> loadPlanets()
        }
    }

    fun loadPlanets() {
        viewModelScope.launch {
            val planets = getPlanets()
            Log.i("Planets", planets.toString())
            _state.update { it.copy(planets = planets) }
        }
    }
}