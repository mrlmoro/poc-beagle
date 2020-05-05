package br.com.mrlmoro.pocbeaglebackend.movie

import br.com.zup.beagle.widget.layout.Screen
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MovieController(private val movieService: MovieService) {

    val logger: Logger = LoggerFactory.getLogger(MovieController::class.java)

    @GetMapping("/movies")
    fun getMoviesScreen(): Screen {
        logger.info("movies")
        return movieService.getMoviesScreen()
    }

    @GetMapping("/movies/best")
    fun getBestMoviesScreen(): Screen {
        logger.info("best")
        return movieService.getBestMoviesScreen()
    }

    @GetMapping("/movies/{id}")
    fun getMovieDetailScreen(@PathVariable("id") id: String): Screen {
        logger.info("movie $id")
        return movieService.getMovieDetailScreen(id)
    }

    @PostMapping("/movies/{id}/like")
    fun postMoviesLike(@PathVariable("id") id: String): ResponseEntity<Void> {
        movieService.addLike(id)
        return ResponseEntity.noContent().build()
    }

}