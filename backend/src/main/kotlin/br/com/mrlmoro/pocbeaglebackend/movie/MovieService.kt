package br.com.mrlmoro.pocbeaglebackend.movie

import br.com.mrlmoro.pocbeaglebackend.movie.screen.BestMoviesScreenBuilder
import br.com.mrlmoro.pocbeaglebackend.movie.screen.MovieDetailScreenBuilder
import br.com.mrlmoro.pocbeaglebackend.movie.screen.MoviesScreenBuilder
import br.com.zup.beagle.widget.layout.Screen
import org.springframework.stereotype.Service

@Service
class MovieService(private val movieRepository: MovieRepository) {

    fun getMoviesScreen(): Screen {
        return MoviesScreenBuilder(movieRepository.getAll()).build()
    }

    fun getBestMoviesScreen(): Screen {
        return BestMoviesScreenBuilder(movieRepository.getBestMovies()).build()
    }

    fun getMovieDetailScreen(id: String): Screen {
        return movieRepository.getMovieById(id)
            ?.let { MovieDetailScreenBuilder(it).build() }
            ?: throw RuntimeException("Movie not found")
    }

    fun addLike(id: String) {
        val movie = movieRepository.getMovieById(id)
            ?: throw RuntimeException("Movie not found")

        movieRepository.update(
            movie.copy(likes = movie.likes + 1)
        )
    }

}