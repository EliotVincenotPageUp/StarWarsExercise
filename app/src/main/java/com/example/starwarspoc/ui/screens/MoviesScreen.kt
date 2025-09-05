package com.example.starwarspoc.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.starwarspoc.ui.movie.MovieEvent
import com.example.starwarspoc.ui.movie.MovieState
import BottomNavBar
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.starwarspoc.MainActivity
import com.example.starwarspoc.ui.components.CardMovie


@Composable
fun MoviesScreen(
    navController: NavController,
    state: MovieState,
    onEvent: (MovieEvent) -> Unit
) {
    LaunchedEffect(Unit) {
        onEvent(MovieEvent.OnLoadMovies)
    }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Movies",
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 41.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))

            LazyColumn {
                items(state.movies) { movie ->
                    CardMovie(
                        title = movie.name,
                        producer = movie.producer
                    )
                }
            }
        }
    }



