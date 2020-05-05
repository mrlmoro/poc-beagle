package br.com.mrlmoro.pocbeagleandroid.beagle

import android.content.Context
import android.widget.ImageView
import br.com.zup.beagle.view.BeagleActivity
import br.com.zup.beagle.view.ScreenRequest
import br.com.zup.beagle.widget.core.ImageContentMode
import br.com.zup.beagle.widget.layout.ScreenBuilder

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

fun Context.startBeaglePreviewActivity(screenBuilder: ScreenBuilder) {
    startActivity(
        BeagleActivity.newIntent(
            context = this,
            screen = screenBuilder.build()
        )
    )
}