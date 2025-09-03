package com.example.starwarspoc.ui.character

import com.example.starwarspoc.domain.Characters


data class CharacterState(
    val characters: List<Characters> = emptyList(),
    )
