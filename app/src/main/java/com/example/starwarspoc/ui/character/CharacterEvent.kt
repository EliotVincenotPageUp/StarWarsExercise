package com.example.starwarspoc.ui.character

sealed interface CharacterEvent {

    data object OnLoadCharacters : CharacterEvent

}
