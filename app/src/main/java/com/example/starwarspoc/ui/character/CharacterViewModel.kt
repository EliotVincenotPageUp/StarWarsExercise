package com.example.starwarspoc.ui.character

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarspoc.data.datasource.getCharacterById
import com.example.starwarspoc.data.datasource.getCharacters
import com.example.starwarspoc.ui.screens.CharacterScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterViewModel (): ViewModel() {


    private val _state = MutableStateFlow(CharacterState())
    val state: StateFlow<CharacterState> = _state.asStateFlow()

    fun onEvent(event: CharacterEvent) {
        when (event) {
            CharacterEvent.OnLoadCharacters -> loadCharacters()
            is CharacterEvent.OnLoadCharacterById -> loadCharactersById(event.id)
        }
    }

    fun loadCharacters() {
        viewModelScope.launch {
            val characters = getCharacters()
            _state.update { it.copy(characters = characters) }
        }
    }

    fun loadCharactersById(id: Int) {
        viewModelScope.launch {
            val character = getCharacterById(id)
            _state.update { it.copy(character = character) }
        }
    }
}

