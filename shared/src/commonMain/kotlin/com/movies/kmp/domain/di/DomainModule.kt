package com.movies.kmp.domain.di

import com.movies.kmp.domain.usecases.GetMovieDetailsUseCase
import com.movies.kmp.domain.usecases.GetMoviesUsecase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val domainModule = module {
    factory(named("AndroidMovieDetail")) {
        GetMovieDetailsUseCase(get())
    }
    factory(named("AndroidMovies")) {
        GetMoviesUsecase(get())
    }
}