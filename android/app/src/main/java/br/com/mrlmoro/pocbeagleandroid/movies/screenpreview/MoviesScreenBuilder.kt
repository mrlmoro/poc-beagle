package br.com.mrlmoro.pocbeagleandroid.movies.screenpreview

import br.com.mrlmoro.pocbeagleandroid.movies.MoviesRecyclerWidget
import br.com.mrlmoro.pocbeagleandroid.movies.moviesMock
import br.com.zup.beagle.widget.core.ImageContentMode
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder

class MoviesScreenBuilder(val contentMode: ImageContentMode) : ScreenBuilder {

    override fun build(): Screen = Screen(
        child = Container(
            children = listOf(
                MoviesRecyclerWidget(
                    movies = moviesMock(),
                    grid = contentMode != ImageContentMode.CENTER_CROP,
                    contentMode = contentMode
                )
            )
        )
    )

}