package com.movies.kmp.domain.di

import com.movies.kmp.domain.usecases.GetMovieDetailsUseCase
import com.movies.kmp.domain.usecases.GetMoviesUsecase
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetMovieDetailsUseCase(get())
    }
    factory {
        GetMoviesUsecase(get())
    }
}