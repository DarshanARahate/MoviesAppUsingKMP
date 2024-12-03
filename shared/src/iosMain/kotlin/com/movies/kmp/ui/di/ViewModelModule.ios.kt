package com.movies.kmp.ui.di

import com.movies.kmp.ui.viewmodel.MovieDetailsViewModel
import com.movies.kmp.ui.viewmodel.MovieViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

private val viewModelModules = module {
    single (named("IOSMovieDetail")) { MovieDetailsViewModel(get()) }
    single (named("IOSMovies")) { MovieViewModel(get()) }
}

actual fun sharedViewModelModule(): Module= viewModelModules

object ProvideViewModel : KoinComponent {
    fun getMovieDetailsViewModel() = get<MovieDetailsViewModel>()
    fun getMovieViewModel() = get<MovieViewModel>()
}