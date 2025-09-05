package com.example.starwarspoc.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.starwarspoc.ui.planet.PlanetEvent
import com.example.starwarspoc.ui.profil.ProfilEvent
import com.example.starwarspoc.ui.profil.ProfilViewModel
import com.example.starwarspoc.ui.profil.ProfilState


@Composable
fun ProfilScreen(
    navController: NavController,
    state: ProfilState,
    onEvent: (ProfilEvent) -> Unit
) {
    LaunchedEffect(Unit) {
        onEvent(ProfilEvent.CreateTestUser)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Profil Screen",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "First name: ${state.firstName}",
            color = Color.White
        )
    }
}

