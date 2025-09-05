package com.example.starwarspoc

import BottomNavBar
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.starwarspoc.data.datasource.initializeDatabase
import com.example.starwarspoc.ui.character.CharacterViewModel
import com.example.starwarspoc.ui.character.characterDetail.CharacterDetailViewModel
import com.example.starwarspoc.ui.movie.MovieViewModel
import com.example.starwarspoc.ui.planet.PlanetViewModel
import com.example.starwarspoc.ui.profil.ProfilViewModel
import com.example.starwarspoc.ui.screens.CharacterDetailScreen
import com.example.starwarspoc.ui.screens.CharacterScreen
import com.example.starwarspoc.ui.screens.HomeScreen
import com.example.starwarspoc.ui.screens.MoviesScreen
import com.example.starwarspoc.ui.screens.PlanetScreen
import com.example.starwarspoc.ui.screens.ProfilScreen
import com.example.starwarspoc.ui.theme.StarWarsPOCTheme

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initializeDatabase(this)
        setContent {
            val navController = rememberNavController()
            val sharedPref = this@MainActivity.getPreferences(Context.MODE_PRIVATE)
            var isDarkTheme by remember {
                mutableStateOf(sharedPref.getBoolean("THEME_MODE_KEY", true))
            }

            StarWarsPOCTheme(darkTheme = isDarkTheme) {
                val navController = rememberNavController()

            Scaffold(
                containerColor = MaterialTheme.colorScheme.background,
                topBar = {
                    Switch(
                        checked = isDarkTheme,
                        modifier = Modifier.padding(18.dp),
                        onCheckedChange = {
                            isDarkTheme = it
                            with (sharedPref.edit()) {
                                putBoolean("THEME_MODE_KEY", isDarkTheme)
                                apply()
                            }
                        }
                    )

                },
                bottomBar = { BottomNavBar(navController) }
            ) { innerPadding ->

                NavHost(
                    navController = navController,
                    startDestination = "home_screen",
                    modifier = Modifier.padding(innerPadding)
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
                    composable("character_detail_screen/{id}") { backStackEntry ->
                        val characterDetailViewModel: CharacterDetailViewModel = viewModel()
                        val state by characterDetailViewModel.state.collectAsState()

                        val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()

                        CharacterDetailScreen(
                            navController = navController,
                            id = id,
                            state = state,
                            onEvent = { event -> characterDetailViewModel.onEvent(event) }
                        )
                    }

                    composable("profil_screen") {
                        val profilViewModel: ProfilViewModel = viewModel()
                        val state by profilViewModel.state.collectAsState()

                        ProfilScreen(
                            navController = navController,
                            state = state,
                            onEvent = { profilViewModel.onEvent(it) }
                        )
                    }

                }
            }
        }
    }
}
}



