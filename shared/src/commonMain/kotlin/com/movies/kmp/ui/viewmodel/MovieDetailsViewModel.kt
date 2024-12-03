package com.movies.kmp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movies.kmp.domain.model.moviedetails.MovieDetails
import com.movies.kmp.domain.usecases.GetMovieDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(DetailsUiState())
    val uiState = _uiState.asStateFlow()

    fun getMovieDetails(imdbId: String) {
        viewModelScope.launch {
            _uiState.update {
                DetailsUiState(isLoading = true)
            }

            val response = getMovieDetailsUseCase.invoke(imdbId)
            if (response.isSuccess) {
                _uiState.update {
                    DetailsUiState(data = response.getOrThrow())
                }
            } else {
                _uiState.update {
                    DetailsUiState(error = response.exceptionOrNull()?.message.toString())
                }
            }
        }
    }
}

data class DetailsUiState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: MovieDetails? = null
)