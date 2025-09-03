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
import com.example.starwarspoc.ui.movie.MovieViewModel
import com.example.starwarspoc.ui.screens.HomeScreen
import com.example.starwarspoc.ui.screens.MoviesScreen

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
            }
        }
    }
}
