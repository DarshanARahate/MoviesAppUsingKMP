package com.movies.kmp.data.remote

import com.movies.kmp.data.model.search.response.SearchMovieResponse
import com.movies.kmp.data.model.searchdetails.response.MovieDetailsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url


const val BASE_URL = "https://www.omdbapi.com/"
const val API_KEY = "apikey"
const val API_KEY_VALUE = ""
const val SEARCH_KEY = "s"
const val DETAILS_KEY = "i"

class ApiService(private val client: HttpClient) {
    suspend fun getMovies(search: String): SearchMovieResponse = client.get {
        url(BASE_URL)
        parameter(API_KEY, API_KEY_VALUE)
        parameter(SEARCH_KEY, search)
    }.body<SearchMovieResponse>()

    suspend fun getMovieDetails(imdbId: String): MovieDetailsResponse = client.get {
        url(BASE_URL)
        parameter(API_KEY, API_KEY_VALUE)
        parameter(DETAILS_KEY, imdbId)
    }.body<MovieDetailsResponse>()
}