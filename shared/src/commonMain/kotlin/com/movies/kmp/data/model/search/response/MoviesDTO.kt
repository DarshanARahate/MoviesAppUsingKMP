package com.movies.kmp.data.model.search.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesDTO(
    @SerialName("imdbID")
    val imdbID: String,
    @SerialName("Poster")
    val poster: String,
    @SerialName("Title")
    val title: String,
    @SerialName("Type")
    val type: String,
    @SerialName("Year")
    val year: String
)