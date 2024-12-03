package com.movies.kmp

import android.app.Application
import com.movies.kmp.data.di.dataModule
import com.movies.kmp.domain.di.domainModule
import com.movies.kmp.ui.di.sharedViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BaseApplication)
            modules(dataModule + domainModule + sharedViewModelModule())
        }
    }
}