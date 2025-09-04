package com.example.starwarspoc.data.datasource

import android.R
import android.util.Log
import com.example.starwarspoc.domain.Characters
import com.example.starwarspoc.domain.Movies
import com.example.starwarspoc.domain.Planets
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

val client = HttpClient(CIO) {
    install(ContentNegotiation) {
        json(Json { ignoreUnknownKeys = true })
    }
}

suspend fun getFilms(): List<Movies> {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

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

suspend fun getCharacters(): List<Characters> {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

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

suspend fun getPlanets(): List<Planets> {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

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
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }
    try {
        val response: HttpResponse = client.get("https://swapi.info/api/people/$id")

        Log.i("API", "Character status: ${response.status}")

        return response.body()
    } finally {
        client.close()
    }
}





