package br.com.mrlmoro.pocbeaglebackend.movie.screen

import br.com.mrlmoro.pocbeaglebackend.movie.Movie
import br.com.mrlmoro.pocbeaglebackend.movie.widget.MoviesRecyclerWidget
import br.com.zup.beagle.widget.core.ImageContentMode
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder

class BestMoviesScreenBuilder(
    private val movies: List<Movie>
) : ScreenBuilder {

    override fun build(): Screen = Screen(
        child = Container(
            children = listOf(
                MoviesRecyclerWidget(
                    movies = movies,
                    grid = false,
                    contentMode = ImageContentMode.CENTER_CROP
                )
            )
        )
    )

}