package br.com.mrlmoro.pocbeagleandroid.movies

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.mrlmoro.pocbeagleandroid.R
import br.com.mrlmoro.pocbeagleandroid.beagle.navigate.ScreenRoutes
import br.com.mrlmoro.pocbeagleandroid.movies.MoviesServerDrivenFragment.Companion.PATH_KEY
import kotlinx.android.synthetic.main.activity_movies_main.*

class MoviesMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_main)

        bottom_menu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.movies -> changeFragment(
                    fragment = buildMoviesFragment("/movies"),
                    tag = R.id.movies.toString()
                )

                R.id.best -> changeFragment(
                    fragment = buildMoviesFragment("/movies/best"),
                    tag = R.id.best.toString()
                )
            }

            return@setOnNavigationItemSelectedListener true
        }

        //TODO For now Beagle cannot invalidate screen cache, so refresh does not work.
        swipe_refresh.isEnabled = false
        swipe_refresh.setOnRefreshListener {
            swipe_refresh.isRefreshing = false
//            getFragment(bottom_menu.selectedItemId.toString())?.refreshView()
        }

        if (savedInstanceState == null) {
            bottom_menu.selectedItemId = R.id.movies
        }
    }

    private fun changeFragment(fragment: MoviesServerDrivenFragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(container.id, fragment, tag)
            .commitAllowingStateLoss()
    }

    private fun buildMoviesFragment(path: String) = MoviesServerDrivenFragment().apply {
        arguments = Bundle().apply { putString(PATH_KEY, path) }
    }

    private fun getFragment(tag: String): MoviesServerDrivenFragment? {
        return supportFragmentManager.findFragmentByTag(tag)
            ?.takeIf { it is MoviesServerDrivenFragment }
            ?.let { it as MoviesServerDrivenFragment }
    }

    private fun goToBestMovies() {
        bottom_menu.selectedItemId = R.id.best
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.action?.apply {
            Log.i("onNewIntent", "action: $this")
            if (this == ScreenRoutes.NAVIGATE_MOVIES_BEST) {
                goToBestMovies()
            }
        }
    }
}