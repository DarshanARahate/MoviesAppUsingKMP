package com.movies.kmp.data.di

import com.movies.kmp.data.remote.ApiService
import com.movies.kmp.data.remote.KtorClient
import com.movies.kmp.data.repository.MovieRepositoryImpl
import com.movies.kmp.domain.repository.MovieRepository
import org.koin.dsl.module

val dataModule = module {
    factory {
        ApiService(KtorClient.client)
    }
    single <MovieRepository> {
        MovieRepositoryImpl(get())
    }
}