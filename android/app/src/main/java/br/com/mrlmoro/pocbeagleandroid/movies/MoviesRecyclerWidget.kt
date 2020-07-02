package br.com.mrlmoro.pocbeagleandroid.movies

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.mrlmoro.pocbeagleandroid.beagle.navigate.ScreenRoutes
import br.com.mrlmoro.pocbeagleandroid.beagle.toScaleType
import br.com.zup.beagle.android.action.Navigate
import br.com.zup.beagle.android.widget.RootView
import br.com.zup.beagle.android.widget.WidgetView
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.core.ImageContentMode

@RegisterWidget
class MoviesRecyclerWidget(
    private val movies: List<Movie>,
    private val grid: Boolean,
    private val contentMode: ImageContentMode
) : WidgetView() {

    override fun buildView(rootView: RootView) = RecyclerView(rootView.getContext()).apply {
        layoutManager = if (grid) {
            GridLayoutManager(context, 2)
        } else {
            LinearLayoutManager(context)
        }
        adapter = MoviesRecyclerAdapter(contentMode.toScaleType()).apply {
            clickListener = { rootView.goToMovieDetailAction(it) }
            notify(movies)
        }
    }

    private fun RootView.goToMovieDetailAction(movie: Movie) {
        Navigate.OpenNativeRoute(
            route = ScreenRoutes.NAVIGATE_MOVIES_DETAIL,
            data = mapOf(
                Pair(MovieDetailActivity.URL_KEY, "/movies/${movie.id}"),
                Pair(MovieDetailActivity.TITLE_KEY, movie.title)
            )
        ).execute(this)
    }

}