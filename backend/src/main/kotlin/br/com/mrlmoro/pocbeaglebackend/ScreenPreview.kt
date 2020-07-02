package br.com.mrlmoro.pocbeaglebackend

import br.com.mrlmoro.pocbeaglebackend.movie.moviesMock
import br.com.mrlmoro.pocbeaglebackend.movie.screen.MovieDetailScreenBuilder
import br.com.zup.beagle.annotation.BeaglePreview
import br.com.zup.beagle.widget.layout.Screen

class ScreenPreview {

    @BeaglePreview
    fun makeComponent(): Screen {
        return MovieDetailScreenBuilder(moviesMock().first()).build()
    }

}