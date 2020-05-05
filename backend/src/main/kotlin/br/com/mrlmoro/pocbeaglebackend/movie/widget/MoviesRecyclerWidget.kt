package br.com.mrlmoro.pocbeaglebackend.movie.widget

import br.com.mrlmoro.pocbeaglebackend.movie.Movie
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.core.ImageContentMode

@RegisterWidget
class MoviesRecyclerWidget(
    val movies: List<Movie>,
    val grid: Boolean,
    val contentMode: ImageContentMode
) : Widget()