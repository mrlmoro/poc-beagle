package br.com.mrlmoro.pocbeaglebackend.movie.screen

import br.com.mrlmoro.pocbeaglebackend.movie.Movie
import br.com.mrlmoro.pocbeaglebackend.widget.RemoteImageWidget
import br.com.zup.beagle.action.CustomAction
import br.com.zup.beagle.analytics.ClickEvent
import br.com.zup.beagle.analytics.ScreenEvent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.*
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Text
import br.com.zup.beagle.widget.ui.TextAlignment

class MovieDetailScreenBuilder(
    private val movie: Movie
) : ScreenBuilder {

    override fun build(): Screen = Screen(
        navigationBar = NavigationBar(
            title = movie.title,
            style = "navigation",
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
    ).applyFlex(
        Flex(
            padding = EdgeValue(
                right = 8.unitReal(),
                left = 8.unitReal()
            )
        )
    )

    private fun banner() = RemoteImageWidget(
        url = movie.bannerUrl,
        contentMode = ImageContentMode.CENTER
    ).applyFlex(
        Flex(
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
        style = "title"
    )

    private fun genres() = Container(
        children = listOf(
            Text(
                text = "Gêneros:",
                style = "bold"
            ),
            Text(
                text = movie.genres
            )
        )
    ).applyFlex(
        Flex(
            margin = EdgeValue(
                top = 8.unitReal()
            )
        )
    )

    private fun duration() = Container(
        children = listOf(
            Text(
                text = "Duração:",
                style = "bold"
            ),
            Text(
                text = "${movie.durationMinutes} minutos"
            )
        )
    ).applyFlex(
        Flex(
            margin = EdgeValue(
                top = 8.unitReal()
            )
        )
    )

    private fun releaseDate() = Container(
        children = listOf(
            Text(
                text = "Data de lançamento:",
                style = "bold"
            ),
            Text(
                text = movie.releaseDate
            )
        )
    ).applyFlex(
        Flex(
            margin = EdgeValue(
                top = 8.unitReal()
            )
        )
    )

    private fun synopsis() = Text(
        text = movie.synopsis,
        alignment = TextAlignment.LEFT
    ).applyFlex(
        Flex(
            margin = EdgeValue(
                all = 16.unitReal()
            )
        )
    )

    private fun buttons() = Container(
        children = listOf(
            imdbButton(),
            likeButton()
        )
    ).applyFlex(
        Flex(
            grow = 1.0,
            justifyContent = JustifyContent.FLEX_END
        )
    )

    private fun imdbButton() = Button(
        text = "IMDb",
        style = "rounded",
        action = CustomAction(
            name = "common:openWeb",
            data = mapOf(Pair("url", movie.imdbUrl))
        ),
        clickAnalyticsEvent = ClickEvent(
            category = "detail_imdb_click"
        )
    ).applyFlex(
        Flex(
            size = Size(
                height = 45.unitReal()
            ),
            margin = EdgeValue(
                all = 16.unitReal()
            )
        )
    )

    private fun likeButton() = Button(
        text = "Gostei!!!",
        style = "rounded",
        action = CustomAction(
            name = "movies:sendLike",
            data = mapOf(Pair("id", movie.id))
        ),
        clickAnalyticsEvent = ClickEvent(
            category = "detail_like_click"
        )
    ).applyFlex(
        Flex(
            size = Size(
                height = 45.unitReal()
            ),
            margin = EdgeValue(
                all = 16.unitReal()
            )
        )
    )

}