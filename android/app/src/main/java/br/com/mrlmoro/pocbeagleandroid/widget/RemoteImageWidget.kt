package br.com.mrlmoro.pocbeagleandroid.widget

import android.content.Context
import android.widget.ImageView
import androidx.core.content.ContextCompat
import br.com.mrlmoro.pocbeagleandroid.R
import br.com.mrlmoro.pocbeagleandroid.beagle.toScaleType
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.core.ImageContentMode
import br.com.zup.beagle.widget.core.WidgetView
import com.bumptech.glide.Glide

@RegisterWidget
class RemoteImageWidget(
    private val url: String,
    private val contentMode: ImageContentMode
) : WidgetView() {

    override fun buildView(context: Context): ImageView {
        return ImageView(context).apply {
            scaleType = contentMode.toScaleType()
            loadUrl(url)
        }
    }

}

fun ImageView.loadUrl(url: String) {
    Glide.with(context)
        .load(url)
        .placeholder(
            ContextCompat.getDrawable(
                context,
                R.drawable.bg_placeholder_android
            )
        )
        .into(this)
}