package com.example.kotapp1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {
    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    private val apiService = MovieApiService.create()

    fun loadPopularMovies() {
        viewModelScope.launch {
            isLoading = true
            error = null

            try {
                val response = apiService.getPopularMovies(MovieApiService.getApiKey())
                movies = response.results
            } catch (e: Exception) {
                error = "Error al cargar las películas: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }

    init {
        loadPopularMovies()
    }
}