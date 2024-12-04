package com.movies.kmp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movies.kmp.domain.model.movie.Movie
import com.movies.kmp.domain.usecases.GetMoviesUsecase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieViewModel(private val getMoviesUsecase: GetMoviesUsecase) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    private val _query = MutableStateFlow("")

    init {
        viewModelScope.launch {
            _query.debounce(1000)
                .filter {
                    it.isNotEmpty()
                }
                .collectLatest {
                    getMovies(it)
                }
        }
    }

    fun updateQuery(search: String) {
        _query.update { search }
    }

    fun getMovies(search: String) = viewModelScope.launch {
        _uiState.update { UiState(isLoading = true) }
        val response = getMoviesUsecase(search)

        if (response.isSuccess) {
            _uiState.update {
                UiState(data = response.getOrThrow())
            }
        } else {
            _uiState.update {
                UiState(error = response.exceptionOrNull()?.message.toString())
            }
        }
    }

}

data class UiState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: List<Movie>? = null
)