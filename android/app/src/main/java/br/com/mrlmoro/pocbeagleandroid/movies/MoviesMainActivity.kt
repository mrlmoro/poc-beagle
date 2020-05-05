package br.com.mrlmoro.pocbeagleandroid.movies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.mrlmoro.pocbeagleandroid.R
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

        swipe_refresh.setOnRefreshListener {
            swipe_refresh.isRefreshing = false
            //TODO For now Beagle cannot invalidate screen cache, so refresh does not work.
            // New library version will be available soon.
            getFragment(bottom_menu.selectedItemId.toString())?.loadView()
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

    fun goToBestMovies() {
        bottom_menu.selectedItemId = R.id.best
    }
}