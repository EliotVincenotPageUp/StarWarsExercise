package com.example.starwarspoc.ui.screens

import BottomNavBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.starwarspoc.ui.planet.PlanetEvent
import com.example.starwarspoc.ui.planet.PlanetState
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.starwarspoc.ui.components.CardPlanet


@Composable
fun PlanetScreen(
    navController: NavController,
    state: PlanetState,
    onEvent: (PlanetEvent) -> Unit
) {
    LaunchedEffect(Unit) {
        onEvent(PlanetEvent.OnLoadPlanet)
    }
    Scaffold(
        containerColor = Color.Black,
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Planets",
                color = Color.Yellow,
                fontSize = 41.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            LazyColumn {
                items(state.planets) { planet ->
                    CardPlanet(
                        planet.name,
                        planet.rotationPeriod
                    )
                }
            }
        }
    }
}