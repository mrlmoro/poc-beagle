package br.com.mrlmoro.pocbeagleandroid.movies

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.com.mrlmoro.pocbeagleandroid.R
import br.com.mrlmoro.pocbeagleandroid.beagle.BASE_URL
import br.com.mrlmoro.pocbeagleandroid.common.showDialog
import br.com.zup.beagle.utils.loadView
import br.com.zup.beagle.utils.setBeagleStateChangedListener
import br.com.zup.beagle.view.BeagleViewState
import br.com.zup.beagle.view.BeagleViewState.*
import br.com.zup.beagle.view.ScreenRequest
import br.com.zup.beagle.view.StateChangedListener
import kotlinx.android.synthetic.main.activity_server_driven.*
import okhttp3.*
import java.io.IOException

class MovieDetailActivity : AppCompatActivity(), StateChangedListener {

    companion object {
        private const val SCREEN_REQUEST_KEY = "SCREEN_REQUEST_KEY"
        private const val TITLE_KEY = "TITLE_KEY"

        fun newIntent(
            context: Context,
            title: String,
            screenRequest: ScreenRequest
        ): Intent {
            return Intent(context, MovieDetailActivity::class.java).apply {
                putExtra(TITLE_KEY, title)
                putExtra(SCREEN_REQUEST_KEY, screenRequest)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server_driven)

        initToolbar()

        intent.getParcelableExtra<ScreenRequest>(SCREEN_REQUEST_KEY)
            ?.run { loadView(this) }
            ?: finish()
    }

    private fun initToolbar() {
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.ic_arrow_white)
        toolbar.setNavigationOnClickListener { onBackPressed() }
        toolbar.title = intent.getStringExtra(TITLE_KEY)
    }

    private fun loadView(screenRequest: ScreenRequest) {
        server_driven_container.loadView(this, screenRequest)
        server_driven_container.setBeagleStateChangedListener(this)
    }

    //Only for sample, must be delegated to ViewModel with LiveData state to show dialogs safe.
    fun sendLike(movieId: String) {
        val request = Request.Builder()
            .url(BASE_URL.plus("/movies/$movieId/like"))
            .post(FormBody.Builder().build())
            .build()

        OkHttpClient().newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                showDialog("Erro inesperado.")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    showDialog("Enviado!")
                } else {
                    showDialog("Erro inesperado.")
                }
            }
        })
    }

    override fun onStateChanged(state: BeagleViewState) {
        when (state) {
            is LoadStarted -> progress.visibility = View.VISIBLE
            is LoadFinished -> progress.visibility = View.GONE
            is Error -> showDialog("Erro inesperado.")
        }
    }
}