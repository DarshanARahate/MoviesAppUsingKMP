package com.movies.kmp.data.di

import com.movies.kmp.data.remote.ApiService
import com.movies.kmp.data.repository.MovieRepositoryImpl
import com.movies.kmp.domain.repository.MovieRepository
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {

    single { provideHttpClient(get()) }

    factory {
        ApiService(get())
    }

    factory {
        MovieRepositoryImpl(get())
    } bind MovieRepository::class
}