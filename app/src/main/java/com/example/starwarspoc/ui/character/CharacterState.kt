package com.example.starwarspoc.ui.character

import com.example.starwarspoc.domain.Character


data class CharacterState(
    val characters: List<Character> = emptyList(),
    val character: Character? = null,
    )
