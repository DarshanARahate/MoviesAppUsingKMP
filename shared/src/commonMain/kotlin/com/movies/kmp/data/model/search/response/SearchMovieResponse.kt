package com.movies.kmp.data.model.search.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchMovieResponse(
    @SerialName("Response")
    val response: String,
    @SerialName("Search")
    val movies: List<MoviesDTO>,
    @SerialName("totalResults")
    val totalResults: String
)