package br.com.mrlmoro.pocbeagleandroid.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.mrlmoro.pocbeagleandroid.R
import br.com.zup.beagle.utils.loadView
import br.com.zup.beagle.utils.setBeagleStateChangedListener
import br.com.zup.beagle.view.BeagleViewState
import br.com.zup.beagle.view.ScreenRequest
import br.com.zup.beagle.view.StateChangedListener
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

    fun loadView() {
        fl_container.removeAllViews()

        fl_container.loadView(
            fragment = this,
            screenRequest = ScreenRequest(arguments?.getString(PATH_KEY) ?: "")
        )

        fl_container.setBeagleStateChangedListener(object : StateChangedListener {
            override fun onStateChanged(state: BeagleViewState) {
                if (state is BeagleViewState.LoadStarted) {
                    progress.visibility = View.VISIBLE
                } else {
                    progress.visibility = View.GONE
                }
            }
        })
    }

}