package com.example.starwarspoc.ui.character

import android.icu.lang.UCharacter
import com.example.starwarspoc.domain.Characters


data class CharacterState(
    val characters: List<Characters> = emptyList(),
    val character: Character? = null,
    )
