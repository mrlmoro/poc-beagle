package br.com.mrlmoro.pocbeagleandroid.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.mrlmoro.pocbeagleandroid.R
import br.com.zup.beagle.android.utils.loadView
import br.com.zup.beagle.android.view.ScreenRequest
import br.com.zup.beagle.android.view.custom.BeagleViewState.LoadStarted
import kotlinx.android.synthetic.main.fragment_movies_server_driven.*

class MoviesServerDrivenFragment : Fragment() {

    companion object {
        const val PATH_KEY = "path-key"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_server_driven, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadView()
    }

    private fun loadView() {
        fl_container.loadView(
            fragment = this,
            screenRequest = ScreenRequest(arguments?.getString(PATH_KEY) ?: "")
        ) {
            if (it is LoadStarted) {
                fl_container.removeAllViews() //Fix crash
                progress.visibility = View.VISIBLE
            } else {
                progress.visibility = View.GONE
            }
        }
    }

    fun refreshView() {
        //TODO Not work for now
        fl_container.removeAllViews()
        loadView()
    }

}