package com.example.starwarspoc.ui.character.characterDetail

import com.example.starwarspoc.domain.Character


sealed interface CharacterDetailEvent {

    data class OnLoadCharacterById (val id: Int): CharacterDetailEvent

}