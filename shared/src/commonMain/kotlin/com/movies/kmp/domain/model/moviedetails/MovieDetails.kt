package com.movies.kmp.domain.model.moviedetails

import com.movies.kmp.data.model.searchdetails.response.Rating

data class MovieDetails(
    val actors: String,
    val awards: String,
    val boxOffice: String,
    val country: String,
    val dVD: String,
    val director: String,
    val genre: String,
    val imdbID: String,
    val imdbRating: String,
    val imdbVotes: String,
    val language: String,
    val metascore: String,
    val plot: String,
    val poster: String,
    val production: String,
    val rated: String,
    val ratings: List<Rating>,
    val released: String,
    val response: String,
    val runtime: String,
    val title: String,
    val type: String,
    val website: String,
    val writer: String,
    val year: String
)