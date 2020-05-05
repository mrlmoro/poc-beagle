package br.com.mrlmoro.pocbeagleandroid.movies

import android.content.Context
import br.com.mrlmoro.pocbeagleandroid.beagle.BASE_URL
import br.com.mrlmoro.pocbeagleandroid.beagle.DefaultActionListener
import br.com.mrlmoro.pocbeagleandroid.common.showDialog
import br.com.zup.beagle.action.ActionListener
import br.com.zup.beagle.action.CustomAction
import br.com.zup.beagle.action.CustomActionHandler
import br.com.zup.beagle.view.ScreenRequest
import okhttp3.*
import java.io.IOException


class MoviesCustomActionHandler : CustomActionHandler {

    fun handle(context: Context, action: CustomAction) {
        handle(context, action, DefaultActionListener())
    }

    override fun handle(context: Context, action: CustomAction, listener: ActionListener) {
        when (action.name) {
            "movies:goToBestMovies" -> context.goToBestMovies()

            "movies:goToMovieDetail" -> context.startMovieDetailActivity(
                title = action.data["title"] ?: "",
                url = "/movies/${action.data["id"]}"
            )

//            "movies:goToMovieDetail" ->
//                context.startBeagleActivity("/movies/${action.data["id"]}")

//            "movies:goToMovieDetail" -> context.startBeaglePreviewActivity(
//                MovieDetailScreenBuilder(moviesMock()[4])
//            )

            "movies:sendLike" -> context.sendLike(action.data["id"] ?: "")
        }
    }

    private fun Context.goToBestMovies() {
        if (this is MoviesMainActivity) {
            goToBestMovies()
        }
    }

    private fun Context.startMovieDetailActivity(title: String, url: String) {
        startActivity(
            MovieDetailActivity.newIntent(
                context = this,
                title = title,
                screenRequest = ScreenRequest(url)
            )
        )
    }

    private fun Context.sendLike(movieId: String) {
        if (this is MovieDetailActivity) {
            sendLike(movieId)
        }
    }

}