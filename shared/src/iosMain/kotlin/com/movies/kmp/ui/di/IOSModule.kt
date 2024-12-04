package com.movies.kmp.ui.di

import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin
import org.koin.dsl.module

fun iosModule() = module {
    single<HttpClientEngineFactory<*>> { Darwin }
}