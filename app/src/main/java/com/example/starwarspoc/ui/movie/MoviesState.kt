package com.example.starwarspoc.ui.movie

import com.example.starwarspoc.domain.Movie

data class MovieState(
    val movies: List<Movie> = emptyList(),
)
