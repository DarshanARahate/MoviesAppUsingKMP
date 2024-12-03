package com.movies.kmp.data.repository

import com.movies.kmp.data.mappers.toDomain
import com.movies.kmp.data.remote.ApiService
import com.movies.kmp.domain.model.movie.Movie
import com.movies.kmp.domain.model.moviedetails.MovieDetails
import com.movies.kmp.domain.repository.MovieRepository

class MovieRepositoryImpl(private val apiService: ApiService) : MovieRepository {
    override suspend fun getMovies(search: String): List<Movie> {
        return apiService.getMovies(search).movies.toDomain()
    }

    override suspend fun getMovieDetails(imdbId: String): MovieDetails {
        return apiService.getMovieDetails(imdbId).toDomain()
    }
}