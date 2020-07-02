package br.com.mrlmoro.pocbeagleandroid.beagle.navigate

import android.content.Intent
import br.com.zup.beagle.android.annotation.BeagleComponent
import br.com.zup.beagle.android.navigation.DeepLinkHandler
import br.com.zup.beagle.android.view.ScreenRequest

@BeagleComponent
class AppDeepLinkHandler : DeepLinkHandler {

    override fun getDeepLinkIntent(
        path: String,
        data: Map<String, String>?,
        shouldResetApplication: Boolean
    ) = Intent(path).apply {
        data?.forEach {
            if (it.key == ScreenDataKey.FIRST_SCREEN_REQUEST_KEY) {
                this.putExtra(it.key, ScreenRequest(it.value))
            } else {
                this.putExtra(it.key, it.value)
            }
        }
    }

}