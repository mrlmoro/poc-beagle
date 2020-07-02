package br.com.mrlmoro.pocbeagleandroid.movies

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.com.mrlmoro.pocbeagleandroid.R
import br.com.mrlmoro.pocbeagleandroid.beagle.BASE_URL
import br.com.mrlmoro.pocbeagleandroid.common.showDialog
import br.com.zup.beagle.android.action.Action
import br.com.zup.beagle.android.utils.loadView
import br.com.zup.beagle.android.view.ScreenRequest
import br.com.zup.beagle.android.view.custom.BeagleViewState.*
import br.com.zup.beagle.android.widget.RootView
import br.com.zup.beagle.annotation.RegisterAction
import kotlinx.android.synthetic.main.activity_server_driven.*
import okhttp3.*
import java.io.IOException

class MovieDetailActivity : AppCompatActivity() {

    companion object {
        const val URL_KEY = "URL_KEY"
        const val TITLE_KEY = "TITLE_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server_driven)

        initToolbar()

        intent.getStringExtra(URL_KEY)
            ?.run { loadView(ScreenRequest(this)) }
            ?: finish()
    }

    private fun initToolbar() {
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.ic_arrow_white)
        toolbar.setNavigationOnClickListener { onBackPressed() }
        toolbar.title = intent.getStringExtra(TITLE_KEY)
    }

    private fun loadView(screenRequest: ScreenRequest) {
        server_driven_container.loadView(this, screenRequest) {
            when (it) {
                is LoadStarted -> {
                    server_driven_container.removeAllViews() //Fix crash
                    progress.visibility = View.VISIBLE
                }
                is LoadFinished -> progress.visibility = View.GONE
                is Error -> showDialog("Erro inesperado.")
            }
        }
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
}

@RegisterAction
data class SendMovieLikeAction(
    val movieId: String
) : Action {

    override fun execute(rootView: RootView) {
        rootView.getContext()
            .takeIf { it is MovieDetailActivity }
            ?.let { it as MovieDetailActivity }
            ?.sendLike(movieId)
    }

}