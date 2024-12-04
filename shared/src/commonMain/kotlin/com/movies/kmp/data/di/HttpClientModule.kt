package com.movies.kmp.data.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging

import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

fun provideHttpClient(engine: HttpClientEngineFactory<*>) = HttpClient(engine) {
    println("=== engine = " + engine)
    install(Logging) {
        logger = Logger.SIMPLE
        level = LogLevel.ALL // Log headers, body, and more
    }
    install(ContentNegotiation) {
        json(
            Json {
                ignoreUnknownKeys = true // Ignores unknown keys in JSON
                isLenient = true // Allows relaxed JSON parsing
            }
        )
    }
}