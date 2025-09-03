package com.example.starwarspoc.ui.movie

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarspoc.data.datasource.getFilms
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    private val _state = MutableStateFlow(MovieState())
    val state: StateFlow<MovieState> = _state.asStateFlow()

    fun onEvent(event: MovieEvent) {
        Log.d("MovieViewModel", "onEvent reçu: $event")
        when (event) {
            MovieEvent.OnLoadMovies -> loadMovies()
        }
    }

    fun loadMovies() {
        viewModelScope.launch {
            val movies = getFilms()
            Log.i("Movies", movies.toString())
            _state.update { it.copy(movies = movies) }
        }
    }
}
