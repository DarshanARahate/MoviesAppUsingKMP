package com.movies.kmp.data.mappers


import com.movies.kmp.data.model.search.response.MoviesDTO
import com.movies.kmp.data.model.searchdetails.response.MovieDetailsResponse
import com.movies.kmp.domain.model.movie.Movie
import com.movies.kmp.domain.model.moviedetails.MovieDetails

fun List<MoviesDTO>.toDomain(): List<Movie> = map {
    Movie(
        poster = it.poster,
        title = it.title,
        type = it.type,
        year = it.year,
        imdbID = it.imdbID
    )
}

fun MovieDetailsResponse.toDomain(): MovieDetails {
    return MovieDetails(
        actors,
        awards,
        boxOffice,
        country,
        dVD,
        director,
        genre,
        imdbID,
        imdbRating,
        imdbVotes,
        language,
        metascore,
        plot,
        poster,
        production,
        rated,
        ratings,
        released,
        response,
        runtime,
        title,
        type,
        website,
        writer,
        year
    )
}