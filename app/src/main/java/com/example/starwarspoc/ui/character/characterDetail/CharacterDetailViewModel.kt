package com.example.starwarspoc.ui.character.characterDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarspoc.data.datasource.getCharacterById
import com.example.starwarspoc.domain.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterDetailViewModel : ViewModel() {
    private val _state = MutableStateFlow(CharacterDetailState())
    val state: StateFlow<CharacterDetailState> = _state.asStateFlow()

    fun onEvent(event: CharacterDetailEvent) {
        when (event) {
            is CharacterDetailEvent.OnLoadCharacterById -> loadCharacterById(event.id)
        }
    }

    private fun loadCharacterById(id: Int) {
        viewModelScope.launch {
            val character = getCharacterById(id)
            _state.update { it.copy(character = character) }
        }
    }
}

