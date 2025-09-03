package com.example.starwarspoc.ui.movie

import com.example.starwarspoc.domain.Movies

data class MovieState(
    val movies: List<Movies> = emptyList(),
)
