package br.com.mrlmoro.pocbeagleandroid.beagle

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import br.com.mrlmoro.pocbeagleandroid.R
import br.com.mrlmoro.pocbeagleandroid.common.showDialog
import br.com.zup.beagle.android.annotation.BeagleComponent
import br.com.zup.beagle.android.view.BeagleActivity
import br.com.zup.beagle.android.view.ServerDrivenState
import kotlinx.android.synthetic.main.activity_server_driven.*

@BeagleComponent
class ServerDrivenActivity : BeagleActivity() {

    override fun getServerDrivenContainerId(): Int = R.id.server_driven_container

    override fun getToolbar(): Toolbar = toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server_driven)
    }

    override fun onServerDrivenContainerStateChanged(state: ServerDrivenState) {
        if (state is ServerDrivenState.Loading) {
            progress.visibility = if (state.loading) View.VISIBLE else View.GONE
        } else if (state is ServerDrivenState.Error) {
            showDialog("Erro inesperado.")
        }
    }
}
