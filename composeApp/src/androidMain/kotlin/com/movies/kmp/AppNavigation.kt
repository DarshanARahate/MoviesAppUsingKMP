package com.movies.kmp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.movies.kmp.screens.details.MovieDetailsScreen
import com.movies.kmp.screens.search.MovieSearchScreen
import com.movies.kmp.ui.viewmodel.MovieDetailsViewModel
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

            MovieSearchScreen(viewModel = koinViewModel<MovieViewModel>()) {
                navController.navigate(Dest.Details(it))
            }
        }
        composable<Dest.Details> {
            val imdbId = it.toRoute<Dest.Details>().imdbId
            val viewModel = koinViewModel<MovieDetailsViewModel>()
            LaunchedEffect(key1 = imdbId) {
                viewModel.getMovieDetails(imdbId)
            }
            MovieDetailsScreen(viewModel = viewModel)
        }
    }
}