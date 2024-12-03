package com.movies.kmp.domain.repository

import com.movies.kmp.domain.model.movie.Movie
import com.movies.kmp.domain.model.moviedetails.MovieDetails

interface MovieRepository {
    suspend fun getMovies(search: String): List<Movie>

    suspend fun getMovieDetails(imdbId: String): MovieDetails
}