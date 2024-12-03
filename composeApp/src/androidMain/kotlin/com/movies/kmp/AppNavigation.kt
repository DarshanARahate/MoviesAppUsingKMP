package com.movies.kmp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.movies.kmp.screens.search.MovieSearchScreen
import com.movies.kmp.ui.viewmodel.MovieViewModel
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel


sealed class Dest {
    @Serializable
    object Search : Dest()
    @Serializable
    data class Details(val imdbId: String) : Dest()
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Dest.Search) {
        composable<Dest.Search> {
//            val viewModel = koinViewModel<MovieViewModel>()
            MovieSearchScreen(viewModel = koinViewModel<MovieViewModel>())
        }
        composable<Dest.Details> { }
    }
}