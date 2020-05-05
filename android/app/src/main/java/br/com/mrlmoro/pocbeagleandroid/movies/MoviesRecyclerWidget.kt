package br.com.mrlmoro.pocbeagleandroid.movies

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.mrlmoro.pocbeagleandroid.beagle.toScaleType
import br.com.zup.beagle.action.CustomAction
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.core.ImageContentMode
import br.com.zup.beagle.widget.core.WidgetView

@RegisterWidget
class MoviesRecyclerWidget(
    private val movies: List<Movie>,
    private val grid: Boolean,
    private val contentMode: ImageContentMode
) : WidgetView() {

    override fun toView(context: Context) = RecyclerView(context).apply {
        layoutManager = if (grid) {
            GridLayoutManager(context, 2)
        } else {
            LinearLayoutManager(context)
        }
        adapter = MoviesRecyclerAdapter(contentMode.toScaleType()).apply {
            clickListener = { context.goToMovieDetailAction(it) }
            notify(movies)
        }
    }

    private fun Context.goToMovieDetailAction(movie: Movie) {
        val action = CustomAction(
            name = "movies:goToMovieDetail",
            data = mapOf(
                Pair("id", movie.id),
                Pair("title", movie.title)
            )
        )

        MoviesCustomActionHandler().handle(this, action)
    }

}