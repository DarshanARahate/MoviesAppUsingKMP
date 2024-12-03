package com.movies.kmp.domain.usecases

import com.movies.kmp.domain.model.moviedetails.MovieDetails
import com.movies.kmp.domain.repository.MovieRepository

class GetMovieDetailsUseCase(private val repository: MovieRepository) {
    operator suspend fun invoke(imdbId: String): Result<MovieDetails> {
        return try {
            val response = repository.getMovieDetails(imdbId)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}