package com.movies.kmp.di

import com.movies.kmp.data.di.dataModule
import com.movies.kmp.domain.di.domainModule
import com.movies.kmp.ui.di.sharedViewModelModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(dataModule + domainModule + sharedViewModelModule())
    }
}