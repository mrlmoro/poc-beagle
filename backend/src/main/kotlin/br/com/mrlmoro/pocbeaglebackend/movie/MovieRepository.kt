package br.com.mrlmoro.pocbeaglebackend.movie

import org.springframework.stereotype.Repository

@Repository
class MovieRepository {

    companion object {
        private val movies = mutableListOf<Movie>()
    }

    fun getAll() = getMovies()

    fun getBestMovies() = getMovies()
        .sortedByDescending { it.likes }
        .take(3)

    fun getMovieById(id: String) = getMovies()
        .find { it.id == id }

    fun update(movie: Movie) {
        val index = movies.indexOfFirst { it.id == movie.id }
        if (index >= 0) {
            movies[index] = movie
        } else {
            throw RuntimeException("Movie not found")
        }
    }

    private fun getMovies(): List<Movie> {
        if (movies.isEmpty()) {
            movies.addAll(moviesMock())
        }

        return movies.toList()
    }
}