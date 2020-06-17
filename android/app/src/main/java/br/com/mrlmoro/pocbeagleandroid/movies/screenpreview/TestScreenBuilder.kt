package br.com.mrlmoro.pocbeagleandroid.movies.screenpreview

import br.com.mrlmoro.pocbeagleandroid.widget.TextHtmlWidget
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.FlexDirection
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.ListView
import br.com.zup.beagle.widget.ui.Text
import br.com.zup.beagle.widget.ui.TextAlignment

class TestScreenBuilder : ScreenBuilder {

    private val titles = listOf(
        "<big><strong>Parasita</strong></big>",
        "Vingadores: Ultimato",
        "<b><i>O Homem Invisível</i></b>",
        "<del>Pantera Negra</del>",
        "Star Wars - O Império Contra-Ataca",
        "De Volta Para o Futuro"
    )

    override fun build() = Screen(
        child = ListView(
            rows = buildGrid()
        )
    )

    private fun buildGrid(): List<Widget> {
        val grid = mutableListOf<Widget>()

        for (i in titles.indices step 2) {
            val widgets = mutableListOf<Widget>()

            titles.getOrNull(i)?.run {
                widgets.add(text(this))
            }

            titles.getOrNull(i + 1)?.run {
                widgets.add(text(this))
            }

            grid.add(containerRow(widgets))
        }

        return grid
    }

    private fun text(text: String) = TextHtmlWidget(
        textWidget = Text(
            text = text,
            style = "title",
            textColor = "#388E3C",
            alignment = TextAlignment.LEFT
        )
    ).applyFlex(
        Flex(
//            size = Size(width = 1000.unitReal()),  Com isso o Text respeita a divisão 50/50 da Row.
            grow = 1.0
        )
    )

    private fun containerRow(widgets: List<Widget>) = Container(
        children = widgets
    ).applyFlex(
        Flex(
            flexDirection = FlexDirection.ROW,
            grow = 1.0,
            margin = EdgeValue(
                top = 8.unitReal(),
                bottom = 8.unitReal()
            )
        )
    )
}