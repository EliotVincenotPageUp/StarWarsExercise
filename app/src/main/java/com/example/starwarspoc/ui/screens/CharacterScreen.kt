package com.example.starwarspoc.ui.screens

import BottomNavBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
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
import com.example.starwarspoc.ui.character.CharacterEvent
import com.example.starwarspoc.ui.character.CharacterState
import com.example.starwarspoc.ui.components.CardCharacter
import androidx.compose.foundation.lazy.itemsIndexed


@Composable
fun CharacterScreen (
    navController: NavController,
    state: CharacterState,
    onEvent: (CharacterEvent) -> Unit
    ) {
        LaunchedEffect(Unit) {
            onEvent(CharacterEvent.OnLoadCharacters)
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Text(
                text = "Characters",
                color = Color.Yellow,
                fontSize = 41.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            LazyColumn {
                itemsIndexed(state.characters) { index, character ->
                    CardCharacter(
                        name = character.name,
                        gender = character.gender,
                        birthday = character.birthYear,
                        onClick = {
                            navController.navigate("character_detail_screen/${index +1}")
                            onEvent(CharacterEvent.OnLoadCharacterById(index + 1))
                        }
                    )
                }
            }
        }
    }
