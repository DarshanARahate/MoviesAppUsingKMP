package com.movies.kmp.ui.di

import com.movies.kmp.ui.viewmodel.MovieDetailsViewModel
import com.movies.kmp.ui.viewmodel.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

private val viewModelModules = module {
    viewModel { MovieDetailsViewModel(get()) }
    viewModel { MovieViewModel(get()) }
}

actual fun sharedViewModelModule(): Module = viewModelModules

