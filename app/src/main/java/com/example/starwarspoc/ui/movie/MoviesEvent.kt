package com.example.starwarspoc.ui.movie

sealed interface MovieEvent {
    data object OnLoadMovies : MovieEvent

}
