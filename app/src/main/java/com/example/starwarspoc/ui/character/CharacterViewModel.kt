package com.example.starwarspoc.ui.character

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarspoc.data.datasource.getCharacters
import com.example.starwarspoc.ui.screens.CharacterScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterViewModel (): ViewModel(){


    private val _state = MutableStateFlow(CharacterState())

    val state: StateFlow<CharacterState> = _state.asStateFlow()

    fun onEvent(event: CharacterEvent) {
        when (event) {
                CharacterEvent.OnLoadCharacters -> loadCharacters()
            }
    }

    fun loadCharacters() {
        viewModelScope.launch {
            val characters = getCharacters()
            _state.update {it.copy(characters=characters)}        }
    }}