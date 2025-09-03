package com.example.starwarspoc.data.datasource

import android.util.Log
import com.example.starwarspoc.domain.Characters
import com.example.starwarspoc.domain.Movies
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

    val response: HttpResponse = client.get("https://swapi.info/api/people")
    return response.body<List<Characters>>()
}
