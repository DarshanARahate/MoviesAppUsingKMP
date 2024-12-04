package com.movies.kmp.ui.di

import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.android.Android
import org.koin.dsl.module

fun androidModule() = module {
    single<HttpClientEngineFactory<*>> { Android }
}