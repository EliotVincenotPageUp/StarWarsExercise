package com.example.starwarspoc.ui.screens

import BottomNavBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.starwarspoc.data.datasource.getCharacters
import com.example.starwarspoc.data.datasource.getFilms
import com.example.starwarspoc.data.datasource.getPlanets
import com.example.starwarspoc.ui.components.InfoCard
import androidx.compose.ui.graphics.Color
import com.example.starwarspoc.R
import com.example.starwarspoc.ui.theme.StarWarsPOCTheme

@Composable
fun HomeScreen(navController: NavController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.starwarslogo),
                contentDescription = "Planète",
                modifier = Modifier.size(250.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                val filmsTotal by produceState(initialValue = 0) {
                    value = getFilms().count()
                }
                InfoCard(
                    title = "Films",
                    subtitle = "Nombre total de films",
                    number = filmsTotal,
                    onClick = {navController.navigate("movies_screen")},
                )
                val planetsTotal by produceState(initialValue = 0) {
                    value = getPlanets().count()
                }
                InfoCard(
                    title = "Planets",
                    subtitle = "Nombre total de planètes",
                    number = planetsTotal,
                    onClick = {navController.navigate("planet_screen")},

                    )

                val charactersTotal by produceState(initialValue = 0) {
                    value = getCharacters().count()
                }
                InfoCard(
                    title = "Characters",
                    subtitle = "Nombre total de personnages",
                    number = charactersTotal,
                    onClick = {navController.navigate("character_screen")},
                    )
            }
        }
    }



