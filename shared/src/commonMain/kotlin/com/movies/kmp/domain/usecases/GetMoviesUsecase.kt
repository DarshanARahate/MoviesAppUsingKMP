package com.movies.kmp.domain.usecases

import com.movies.kmp.domain.model.movie.Movie
import com.movies.kmp.domain.repository.MovieRepository

class GetMoviesUsecase(private val repository: MovieRepository) {

    operator suspend fun invoke(search: String): Result<List<Movie>> =
        try {
            val response = repository.getMovies(search)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }

}