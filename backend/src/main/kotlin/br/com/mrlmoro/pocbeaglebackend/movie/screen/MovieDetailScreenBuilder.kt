package br.com.mrlmoro.pocbeaglebackend.movie.screen

import br.com.mrlmoro.pocbeaglebackend.movie.Movie
import br.com.mrlmoro.pocbeaglebackend.movie.action.SendMovieLikeAction
import br.com.mrlmoro.pocbeaglebackend.widget.CustomButtonWidget
import br.com.mrlmoro.pocbeaglebackend.widget.RemoteImageWidget
import br.com.mrlmoro.pocbeaglebackend.widget.TextHtmlWidget
import br.com.zup.beagle.analytics.ClickEvent
import br.com.zup.beagle.analytics.ScreenEvent
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyFlex
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.*
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Text

class MovieDetailScreenBuilder(
    private val movie: Movie
) : ScreenBuilder {

    override fun build(): Screen = Screen(
        navigationBar = NavigationBar(
            title = movie.title,
            styleId = "navigation",
            showBackButton = true
        ),
        screenAnalyticsEvent = ScreenEvent(
            screenName = "movie_detail_${movie.id}"
        ),
        child = ScrollView(
            scrollBarEnabled = true,
            children = listOf(container())
        )
    )

    private fun container() = Container(
        children = listOf(
            bannerAndDetails(),
            synopsis(),
            buttons()
        )
    ).applyFlex(
        Flex(
            grow = 1.0
        )
    )

    private fun bannerAndDetails() = Container(
        children = listOf(
            banner(),
            details()
        )
    ).applyFlex(
        Flex(
            flexDirection = FlexDirection.ROW
        )
    )

    private fun details() = Container(
        children = listOf(
            title(),
            genres(),
            duration(),
            releaseDate()
        )
    ).applyStyle(
        Style(
            padding = EdgeValue(
                right = 8.unitReal(),
                left = 8.unitReal()
            )
        )
    )

    private fun banner() = RemoteImageWidget(
        url = movie.bannerUrl,
        contentMode = ImageContentMode.CENTER
    ).applyStyle(
        Style(
            size = Size(
                width = 160.unitReal(),
                height = 230.unitReal(),
                minWidth = 160.unitReal(),
                minHeight = 230.unitReal()
            )
        )
    )

    private fun title() = Text(
        text = movie.title,
        styleId = "title"
    )

    private fun genres() = Container(
        children = listOf(
            Text(
                text = "Gêneros:",
                styleId = "bold"
            ),
            Text(
                text = movie.genres
            )
        )
    ).applyStyle(
        Style(
            margin = EdgeValue(
                top = 8.unitReal()
            )
        )
    )

    private fun duration() = Container(
        children = listOf(
            Text(
                text = "Duração:",
                styleId = "bold"
            ),
            Text(
                text = "${movie.durationMinutes} minutos"
            )
        )
    ).applyStyle(
        Style(
            margin = EdgeValue(
                top = 8.unitReal()
            )
        )
    )

    private fun releaseDate() = Container(
        children = listOf(
            Text(
                text = "Data de lançamento:",
                styleId = "bold"
            ),
            Text(
                text = movie.releaseDate
            )
        )
    ).applyStyle(
        Style(
            margin = EdgeValue(
                top = 8.unitReal()
            )
        )
    )

    private fun synopsis() = TextHtmlWidget(
        textWidget = Text(
            text = movie.synopsis,
            alignment = TextAlignment.LEFT
        )
    ).applyStyle(
        Style(
            margin = EdgeValue(
                all = 16.unitReal()
            )
        )
    )

    private fun buttons() = Container(
        children = mutableListOf<Widget>().apply {
            movie.primeVideoUrl?.run { add(primeVideoButton(this)) }
            add(imdbButton())
            add(likeButton())
        }
    ).applyFlex(
        Flex(
            grow = 1.0,
            justifyContent = JustifyContent.FLEX_END
        )
    )

    private fun primeVideoButton(url: String) = CustomButtonWidget(
        buttonWidget = Button(
            text = "Prime Video",
            onPress = listOf(Navigate.OpenExternalURL(url)),
            clickAnalyticsEvent = ClickEvent(category = "detail_primevideo_click")
        )
    ).applyStyle(
        Style(
            size = Size(
                height = 45.unitReal()
            ),
            margin = EdgeValue(
                all = 16.unitReal()
            )
        )
    )

    private fun imdbButton() = CustomButtonWidget(
        buttonWidget = Button(
            text = "IMDb",
            styleId = "rounded",
            onPress = listOf(Navigate.OpenExternalURL(movie.imdbUrl)),
            clickAnalyticsEvent = ClickEvent(category = "detail_imdb_click")
        )
    ).applyStyle(
        Style(
            size = Size(
                height = 45.unitReal()
            ),
            margin = EdgeValue(
                all = 16.unitReal()
            )
        )
    )

    private fun likeButton() = CustomButtonWidget(
        buttonWidget = Button(
            text = "Gostei!!!",
            styleId = "rounded",
            onPress = listOf(SendMovieLikeAction(movie.id)),
            clickAnalyticsEvent = ClickEvent(category = "detail_like_click")
        )
    ).applyStyle(
        Style(
            size = Size(
                height = 45.unitReal()
            ),
            margin = EdgeValue(
                all = 16.unitReal()
            )
        )
    )

}