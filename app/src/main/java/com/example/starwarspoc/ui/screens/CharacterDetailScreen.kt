package com.example.starwarspoc.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.starwarspoc.ui.character.characterDetail.CharacterDetailEvent
import com.example.starwarspoc.ui.character.characterDetail.CharacterDetailState
import com.example.starwarspoc.ui.components.CardDetailCharacter

@Composable
fun CharacterDetailScreen(
    navController: NavController,
    id: Int?,
    state: CharacterDetailState,
    onEvent: (CharacterDetailEvent) -> Unit
) {
    LaunchedEffect(id) {
        if(id!=null){
            onEvent(CharacterDetailEvent.OnLoadCharacterById(id))
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Character Detail",
            color = MaterialTheme.colorScheme.secondary,
            fontSize = 41.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )


        Spacer(modifier = Modifier.height(24.dp))

        state.character?.let { character ->
            CardDetailCharacter(character)

        }
    }
}
