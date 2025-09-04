package com.example.starwarspoc.data.datasource

import android.util.Log
import com.example.starwarspoc.domain.Character
import com.example.starwarspoc.domain.Movie
import com.example.starwarspoc.domain.Planet
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

val client = HttpClient(CIO) {
    install(ContentNegotiation) {
        json(Json { ignoreUnknownKeys = true })
    }
    install(Logging){
        logger = Logger.ANDROID
        level = LogLevel.ALL
    }
}

suspend fun getFilms(): List<Movie> {
    return try {
        val response: HttpResponse = client.get("https://swapi.info/api/films")
        Log.i("API", "Films status: ${response.status}")
        response.body()
    } catch (e: Exception) {
        Log.e("API", "Erreur getFilms: ${e.message}", e)
        emptyList()
    } finally {
        client.close()
    }
}

suspend fun getCharacters(): List<Character> {
    return try {
        val response: HttpResponse = client.get("https://swapi.info/api/people")
        Log.i("API", "Characters status: ${response.status}")
        response.body()
    } catch (e: Exception) {
        Log.e("API", "Erreur getCharacters: ${e.message}", e)
        emptyList()
    } finally {
        client.close()
    }
}

suspend fun getPlanets(): List<Planet> {
    return try {
        val response: HttpResponse = client.get("https://swapi.info/api/planets")
        Log.i("API", "Planets status: ${response.status}")
        response.body()
    } catch (e: Exception) {
        Log.e("API", "Erreur getplanets: ${e.message}", e)
        emptyList()
    } finally {
        client.close()
    }
}

suspend fun getCharacterById(id: Int): Character {
    try {
        val response: HttpResponse = client.get("https://swapi.info/api/people/$id")

        Log.i("API", "Character status by Id: ${response.status}")

        return response.body()
    } finally {
        client.close()
    }
}





