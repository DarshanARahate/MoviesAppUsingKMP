package com.movies.kmp.screens.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.movies.kmp.ui.viewmodel.MovieViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MovieSearchScreen(modifier: Modifier = Modifier, viewModel: MovieViewModel) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var query by rememberSaveable {
        mutableStateOf("")
    }

    Scaffold(topBar = {
        TextField(
            value = query, onValueChange = {
                query = it
                viewModel.updateQuery(query)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedLabelColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            )
        )
    }) {
        if (uiState.isLoading) {
            Box(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        if (uiState.error.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = uiState.error)
            }
        }

        uiState.data?.let { response ->
            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                items(response) {
                    Column(
                        modifier = Modifier
                            .padding(
                                horizontal = 16.dp,
                                vertical = 4.dp
                            )
                            .fillMaxWidth()
                    ) {
                        GlideImage(
                            imageModel = { it.poster },
                            modifier = Modifier
                                .fillMaxWidth(),
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = it.title,
                            style = MaterialTheme.typography.h4
                        )
                    }
                }
            }
        }
    }
}