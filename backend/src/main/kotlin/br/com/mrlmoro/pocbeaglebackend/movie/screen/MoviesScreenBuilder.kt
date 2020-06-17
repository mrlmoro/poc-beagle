package br.com.mrlmoro.pocbeaglebackend.movie.screen

import br.com.mrlmoro.pocbeaglebackend.movie.Movie
import br.com.mrlmoro.pocbeaglebackend.movie.widget.MoviesRecyclerWidget
import br.com.zup.beagle.action.CustomAction
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.ImageContentMode
import br.com.zup.beagle.widget.core.Size
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Button

class MoviesScreenBuilder(
    private val movies: List<Movie>
) : ScreenBuilder {

    override fun build(): Screen = Screen(
        child = Container(
            children = listOf(
                Button(
                    text = "Veja os melhores",
                    action = CustomAction(
                        name = "movies:goToBestMovies",
                        data = emptyMap()
                    )
                ).applyFlex(
                    Flex(
                        size = Size(
                            height = 100.unitReal()
                        ),
                        margin = EdgeValue(
                            all = 16.unitReal()
                        )
                    )
                ),
                MoviesRecyclerWidget(
                    movies = movies,
                    grid = false,
                    contentMode = ImageContentMode.CENTER_CROP
                )
            )
        )
    )

}