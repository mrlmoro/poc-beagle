package br.com.mrlmoro.pocbeaglebackend.movie.screen

import br.com.mrlmoro.pocbeaglebackend.navigate.ScreenRoutes
import br.com.mrlmoro.pocbeaglebackend.movie.Movie
import br.com.mrlmoro.pocbeaglebackend.movie.widget.MoviesRecyclerWidget
import br.com.mrlmoro.pocbeaglebackend.widget.CustomButtonWidget
import br.com.zup.beagle.analytics.ClickEvent
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.core.EdgeValue
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
                CustomButtonWidget(
                    buttonWidget = Button(
                        text = "Veja os melhores",
                        styleId = "rounded",
                        clickAnalyticsEvent = ClickEvent(category = "see_best_movies_click"),
                        onPress = listOf(Navigate.OpenNativeRoute(ScreenRoutes.NAVIGATE_MOVIES_BEST))
                    )
                ).applyStyle(
                    Style(
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