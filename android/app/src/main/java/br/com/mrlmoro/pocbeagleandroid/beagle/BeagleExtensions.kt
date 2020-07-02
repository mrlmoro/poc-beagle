package br.com.mrlmoro.pocbeagleandroid.beagle

import android.content.Context
import android.widget.ImageView
import br.com.zup.beagle.android.view.BeagleActivity
import br.com.zup.beagle.android.view.ScreenRequest
import br.com.zup.beagle.widget.core.ImageContentMode

fun ImageContentMode.toScaleType(): ImageView.ScaleType {
    return when (this) {
        ImageContentMode.FIT_XY -> ImageView.ScaleType.FIT_XY
        ImageContentMode.CENTER -> ImageView.ScaleType.CENTER
        ImageContentMode.CENTER_CROP -> ImageView.ScaleType.CENTER_CROP
        ImageContentMode.FIT_CENTER -> ImageView.ScaleType.FIT_CENTER
    }
}

fun Context.startBeagleActivity(url: String) {
    startActivity(
        BeagleActivity.newIntent(
            context = this,
            screenRequest = ScreenRequest(url)
        )
    )
}