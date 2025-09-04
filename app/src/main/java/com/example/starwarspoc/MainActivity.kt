package com.example.starwarspoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.starwarspoc.ui.character.CharacterState
import com.example.starwarspoc.ui.character.CharacterViewModel
import com.example.starwarspoc.ui.movie.MovieViewModel
import com.example.starwarspoc.ui.planet.PlanetViewModel
import com.example.starwarspoc.ui.screens.CharacterScreen
import com.example.starwarspoc.ui.screens.HomeScreen
import com.example.starwarspoc.ui.screens.MoviesScreen
import com.example.starwarspoc.ui.screens.PlanetScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()


            NavHost(
                navController = navController,
                startDestination = "home_screen"
            ) {
                composable("home_screen") {
                    HomeScreen(navController)
                }
                composable("movies_screen") {
                    val movieViewModel: MovieViewModel = viewModel()
                    val state by movieViewModel.state.collectAsState()

                    MoviesScreen(
                        navController = navController,
                        state = state,
                        onEvent = { event -> movieViewModel.onEvent(event) }
                    )
                }
                composable("character_screen") {
                    val characterViewModel: CharacterViewModel = viewModel()
                    val state by characterViewModel.state.collectAsState()

                    CharacterScreen(
                        navController = navController,
                        state = state,
                        onEvent = { event -> characterViewModel.onEvent(event) }
                    )
                }

                composable("planet_screen") {
                    val planetViewModel: PlanetViewModel = viewModel()
                    val state by planetViewModel.state.collectAsState()

                    PlanetScreen(
                        navController = navController,
                        state = state,
                        onEvent = { event -> planetViewModel.onEvent(event) }
                    )
                }
            }
        }
    }
}
